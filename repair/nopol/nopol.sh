#!/bin/bash

export JAVA_HOME=/usr/lib/jvm/java-7-oracle/


cd /nopol/test-projects && java -jar /nopol/nopol/target/nopol-0.2-SNAPSHOT-jar-with-dependencies.jar \
-s src/main/java/ \
-c target/classes:target/test-classes:/root/.m2/repository/junit/junit/4.11/junit-4.11.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar \
-t symbolic_examples.symbolic_example_1.NopolExampleTest \
-p /z3/build/z3

#-t symbolic_examples.symbolic_example_3.NopolExampleTest \
echo $?
