# repair-cluster

Infrastructure for scalable program repair.

Repair is performed as a collection of Nomad jobs. Jobs report their repair output to a Consul key/value store.

### Contents

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

### Setup

    # provision cluster
    vagrant up

    # Install cluster
    vagrant ssh control
    cd harness 
    ansible-playbook -i inventory playbooks/bootstrap-cluster.yml

    # Install nomad and consul (need sudo, ensures has rights to /etc/ansible/roles)
    sudo ansible-playbook -i inventory playbooks/install-nomad.yml

    # Run jobs in cluster.
    ansible-playbook -i inventory playbooks/run-nomad-jobs.yml

### Monitor and See Results

Inside nomad1 (`vagrant ssh nomad1`):

Watch jobs: `watch -n 10 nomad status`
Stream job output in nomad: `nomad logs -f c5955147`

To see results stored in consul, visit http://192.168.77.11:8500

### Test a repair manually using docker image.

```
vagrant ssh nomad1
SCRIPT_DIR=~/nomad/scripts
DATA_DIR=~/nomad/data

cd $SCRIPT_DIR 
docker run --rm -it -v$SCRIPT_DIR:/scripts -v$DATA_DIR:/data chrisparnin/astor-d4j /scripts/repair_user_test.sh MATH-1021 Math 2 --user org.apache.commons 192.168.77.11:8500
```

### Running ACS repair.

See instructions at: https://github.com/Adobee/ACS

```
docker pull chrisparnin/acs
docker run --rm -it chrisparnin/acs:latest

defects4j checkout -p Lang -v 7b -w /tmp/Lang_7
cd /tmp/Lang_7 && defects4j compile

cd /ACS && java -jar ACS.jar /tmp/ Lang_7
```

Time to repair in /ACS/resultMessage/fixResult.log
Patch in 
