# repair-cluster

_Infrastructure for scalable program repair._

Repair on defects is performed as a collection of Nomad jobs. Each Nomad Job runs a repair on a specified defects4j bug inside a Docker container. Jobs report their repair output to a Consul key/value store.

## Contents

The `repair` directory includes Dockerfile specifications for environments that can run the respective tool. We also provide a defects4j Dockerfile. Prebuilt images are also available on [DockerHub](https://hub.docker.com/u/chrisparnin/).

The `cluster` directory includes the configuration scripts necessary for setting up the cluster. 

The nomad jobs can be configured by modifying the `repair-cluster/cluster/data/bugs.json`:

```
{
    "packages": [
        {"bug": "TIME-88",  "PID": "Time", "BID":4, "mode": "dev", "namespace": "org.joda.time"},
        {"bug": "MATH-950",  "PID": "Math", "BID":7, "mode": "user", "namespace": "org.apache.commons"}
    ]
}
```

The `runs` directory includes example output the is accessible from the consul cluster. A utility script, convert.js can be run to help convert the provided patch with escape characters into a readable patch.

The `data` directory includes a repairable.csv that describes the tool (jgenprog/ACS), Defects4J bug, paper source, whether a patch can be produced, and whether that patch was determined to be correct by the original authors.

## Setup

#### Preqs

To create the virtual machine, you will need [VirtualBox](https://www.virtualbox.org/) and [Vagrant](https://www.vagrantup.com/) installed.

Tips for creating virtual machines with these tools, as well as common problems you may encounter can be viewed in [this guide](https://github.com/chrisparnin/ComputingEnvironmentsWorkshop/blob/master/VM.md).

#### Provision cluster VMs in VirtualBox

    # provision cluster
    vagrant up

#### Configure ansible control box and cluster.

Note: This step might take a while.

    # Install cluster
    vagrant ssh control
    cd harness 
    ansible-playbook -i inventory playbooks/bootstrap-cluster.yml

    # Install nomad and consul (need sudo, ensures has rights to /etc/ansible/roles)
    sudo ansible-playbook -i inventory playbooks/install-nomad.yml

Verify Consul is accessible. (http://192.168.33.11:8500/ui for Vagrant)

## Schedule nomad jobs

    # Run jobs in cluster.
    ansible-playbook -i inventory playbooks/run-nomad-jobs.yml

#### Monitor and See Results

Inside nomad1 (`vagrant ssh nomad1`):

Watch jobs: `watch -n 10 nomad status`
Stream job output in nomad: `nomad logs -f c5955147`

To see results stored in consul, visit http://192.168.77.11:8500

#### Tips and Tricks

Run job and check status
```
nomad run example.nomad
nomad job status example
```

View logs for a specific task
```
nomad fs <alloc-id> alloc/logs/task.stdout.0
```

Purge records of a previous job.
```
nomad stop -purge <job>
```

View status of a specific allocation.
```
nomad alloc-status <alloc-id>
```

#### Test a repair manually using docker image.

```
vagrant ssh nomad1
SCRIPT_DIR=~/nomad/scripts
DATA_DIR=~/nomad/data

cd $SCRIPT_DIR 
docker run --rm -it -v$SCRIPT_DIR:/scripts -v$DATA_DIR:/data chrisparnin/astor-d4j /scripts/repair_user_test.sh MATH-1021 Math 2 --user org.apache.commons 192.168.77.11:8500
```

#### Running ACS repair manually.

```
docker pull chrisparnin/acs
docker run --rm -it chrisparnin/acs:latest

defects4j checkout -p Lang -v 7b -w /tmp/Lang_7
cd /tmp/Lang_7 && defects4j compile

cd /ACS && java -jar ACS.jar /tmp/ Lang_7
```

To run a repair of a user provided test manually, provide a volume that contains the user tests, e.g.:
```
docker run --rm -it -v/tmp/repair-cluster/user_test:/user_test/ chrisparnin/acs:latest
```

Remove the triggering test(s)
```
SUBJECT_TESTDIR=$(cd /tmp/Lang_7 && defects4j export -p dir.src.tests)
$D4J_HOME/framework/util/rm_broken_tests.pl $D4J_HOME/framework/projects/LANG/7 /tmp/Lang_7/$SUBJECT_TESTDIR
```
Copy the user test in place
```
cp /user_test/LANG822.java /tmp/Lang_7/$SUBJECT_TESTDIR/
```

Run ACS
```
cd /tmp/Lang_7 && defects4j compile

cd /ACS && java -jar ACS.jar /tmp/ Lang_7
```

Time to repair is located in /ACS/resultMessage/fixResult.log

The results are in the dir "ACS/resultMessage", the detailed patch is in the file "ACS/resultMessage/patchSource/Project_BugId_Schema_PatchId.java"(If a bug has n patches, the "PatchId" will range from 0 to n - 1), and is between "patch begin" and "patch end".

Additional details about ACS can be seen at: https://github.com/Adobee/ACS
