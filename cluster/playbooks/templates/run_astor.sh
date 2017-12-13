#!/bin/bash
SUBJECT_CLASSPATH=$1
DEP=$2
BUGGY_DIR=$3
CLASSNAME=$4
TRIGGERING_TEST=$5

JVM=/usr/lib/jvm/java-7-oracle/bin/

cd /astor && java -cp $(cat /tmp/astor-classpath.txt):$SUBJECT_CLASSPATH:target/classes\
       fr.inria.main.evolution.MainjGenProg -dependencies $DEP -maxgen 40000\
       -location $BUGGY_DIR -package org.apache.commons\
       -javacompliancelevel 7 -alternativecompliancelevel 7 -jvm4testexecution $JVM\
       -flthreshold 0.08 -id $CLASSNAME -mode statement -stopfirst true\
       -failing $TRIGGERING_TEST
