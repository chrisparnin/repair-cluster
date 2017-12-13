#!/usr/bin/env bash
#
# This script verifies that a user-submitted triggering test:
# - compiles
# - fails on the buggy version
# - passes on the fixed version
#
# This script expects one argument:
# - issue-tracker-id: the issue tracker ID as listed in ../bug-tracker-IDs.csv
#
# Example:
# ./verify.sh LANG-818
#

# Print error message and exit with error code 1
function die {
    echo "$1"
    exit 1
}

# Check the number of arguments
[ $# -eq 4 ] || [ $# -eq 5 ] || die "usage: $0 <issuer-tracker-id> <d4jpid> <d4jbid> <--user or --dev> [consul-address]"
ISSUE_ID=$1
client_addr=$5

# The csv file that maps Defects4J's bug id to the issue id
ID_CSV="/data/bug-tracker-IDs.csv"
# The temporary directory used to checkout the buggy and fixed program version
TMP_DIR="/tmp/TestsTested"

# The directory of the user-submitted triggering tests
USERTEST_DIR=/data/user_test


function removeTriggeringTests
{
    local buggyDir=$1
    local testDir=$(cd $buggyDir && defects4j export -p dir.src.tests)
    local triggeringTests=$(cd $buggyDir && defects4j export -p tests.trigger)
    for element in "${triggeringTests[@]}"
    do
        local testCase=$(echo "${element}" | awk -F'::' '{print $1}' | sed 's/\./\//g')
        echo $buggyDir/$testDir/$testCase.java
        [ -f $buggyDir/$testDir/$testCase.java ] || die "Could not find triggering test case file"
        #rm $buggyDir/$testDir/$testCase.java
    done
}

function getTestsTriggeringTestsToIgnore
{
    local buggyDir=$1
    local triggeringTests=$(cd $buggyDir && defects4j export -p tests.trigger)
    local val=$(echo "${triggeringTests}" | awk -F'::' '{print $1}' |  tr '\n' ':')
    echo $val
}


# Set project and bug id 
PID=$2
BID=$3

# Class names don't include the dash
CLASSNAME="$(echo $ISSUE_ID | tr -d '-')Test"
MODE="$(echo $4 | tr -d '-')"
D4J_HOME=/defects4j

# Create temporary directory, if necessary
mkdir -p $TMP_DIR



BUGGY_DIR="$TMP_DIR/$PID-${BID}b"
FIXED_DIR="$TMP_DIR/$PID-${BID}f"

# Defects4J directories for given project id (PID)
DIR_PROJECT="$D4J_HOME/framework/projects/$PID"
DIR_TRIGGER_TESTS="$DIR_PROJECT/trigger_tests"

# Checkout the buggy version
# Remove the buggy dir as checkout does not undo commenting out triggering tests.
rm -rf $BUGGY_DIR
defects4j checkout -p$PID -v${BID}b -w $BUGGY_DIR || die "Can't checkout buggy version"
# Checkout the fixed version
#defects4j checkout -p$PID -v${BID}f -w $FIXED_DIR || die "Can't checkout fixed version"

cd $BUGGY_DIR && defects4j compile || die "cannot compile"


if [ $MODE = "user" ]; then
    echo "removing triggering tests from dev and adding user tests"
    # Remove triggering dev provided triggering tests:

    SUBJECT_TESTDIR=$(cd $BUGGY_DIR && defects4j export -p dir.src.tests)
    $D4J_HOME/framework/util/rm_broken_tests.pl $DIR_TRIGGER_TESTS/$BID $BUGGY_DIR/$SUBJECT_TESTDIR || die "Could not comment out triggering test."

    # Copy user test
    #TRIGGERING_TEST=usertest.$CLASSNAME
    #mkdir -p $BUGGY_DIR/$SUBJECT_TESTDIR/usertest
    #cp $TEST_DIR/$CLASSNAME.java $BUGGY_DIR/$SUBJECT_TESTDIR/usertest || die 'could not copy user test case'
    TRIGGERING_TEST=$CLASSNAME
    cp $USERTEST_DIR/$CLASSNAME.java $BUGGY_DIR/$SUBJECT_TESTDIR/ || die "could not copy user test case"
else
    TRIGGERING_TEST=$(defects4j info -p$PID -b$BID | grep "Root cause in trigger" --after-context=1 | tail -n 1 | tr -d "-" | awk -F'::' '{print $1}')
fi

# Bug with spoon: https://github.com/INRIA/spoon/issues/1274
# Recommended by astor's authors to delete all package-info.java
cd $BUGGY_DIR && find . -name "package-info.java" -type f -delete

#ASTOR_CLASSPATH="/home/vagrant/.m2/repository/com/googlecode/json-simple/json-simple/1.1/json-simple-1.1.jar:/home/vagrant/.m2/repository/com/gzoltar/gzoltar/0.1.1/gzoltar-0.1.1.jar:/home/vagrant/.m2/repository/com/martiansoftware/jsap/2.1/jsap-2.1.jar:/home/vagrant/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/home/vagrant/.m2/repository/commons-collections/commons-collections/3.2.1/commons-collections-3.2.1.jar:/home/vagrant/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5.jar:/home/vagrant/.m2/repository/fr/inria/gforge/spoon/spoon-core/5.4.0/spoon-core-5.4.0.jar:/home/vagrant/.m2/repository/fr/spoonlab/jte/0.0.1/jte-0.0.1.jar:/home/vagrant/.m2/repository/junit/junit/4.11/junit-4.11.jar:/home/vagrant/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/home/vagrant/.m2/repository/org/eclipse/jdt/org.eclipse.jdt.core/3.12.0.v20160516-2131/org.eclipse.jdt.core-3.12.0.v20160516-2131.jar:/home/vagrant/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar"
#ASTOR_CLASSPATH=$(cd ~/astor && mvn dependency:build-classpath | egrep -v "(^\[INFO\]|^\[WARNING\])" | egrep -v "Download")
#SUBJECT_CLASSPATH=$(cd $BUGGY_DIR && mvn dependency:build-classpath | egrep -v "(^\[INFO\]|^\[WARNING\])" | egrep -v "Download")
SUBJECT_CLASSPATH=$(cd $BUGGY_DIR && defects4j export -p cp.test 2> /dev/null)
echo "meta:", $SUBJECT_CLASSPATH, $CLASSNAME, $PID, $BID, $TRIGGERING_TEST
#echo $BUGGY_DIR
#echo $ASTOR_CLASSPATH:$SUBJECT_CLASSPATH "---"

#IGNORETESTCASES=$(getTestsTriggeringTestsToIgnore $BUGGY_DIR)

# JAVA_HOME=/usr/lib/jvm/java-7-oracle/
# :target/classes
DEP=$SUBJECT_CLASSPATH

/scripts/run_astor.sh $SUBJECT_CLASSPATH $DEP $BUGGY_DIR $CLASSNAME $TRIGGERING_TEST > /tmp/astor.txt
#astor_output='{"output": "$(cat /tmp/astor.txt)" }'

cat /tmp/astor.txt

astor_output=$(</astor/output_astor/AstorMain-$CLASSNAME/astor_output.json)

curl --request PUT -H "Content-Type: application/json" --data "$astor_output" http://$client_addr/v1/kv/$PID-$BID/$MODE

#/astor/output_astor/AstorMain-$CLASSNAME/astor_output.json

#       -ignoredtestcases $IGNORETESTCASES\
#       -srctestfolder /user_tests/$CLASSNAME -bintestfolder /user_tests/$CLASSNAME

echo "SUCCESSFUL: All checks passed"
