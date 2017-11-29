FROM ubuntu:trusty

RUN apt-get update -qq
RUN apt-get install -y git
RUN apt-get install -y software-properties-common
RUN apt-get install -y debconf

RUN add-apt-repository ppa:webupd8team/java
RUN apt-get update

RUN echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections

RUN apt-get install -y oracle-java8-installer
RUN apt-get install -y maven

RUN git clone https://github.com/SpoonLabs/astor

RUN cd /astor && mvn clean && mvn test -DskipTests

RUN cd /astor && mvn dependency:build-classpath | egrep -v "(^\[INFO\]|^\[WARNING\])" | egrep -v "Download" | tee /tmp/astor-classpath.txt

# compile example
RUN cd /astor/examples/Math-issue-280 && mvn clean compile test; exit 0

ENV ASTOR_CP $(cat /tmp/astor-classpath.txt)
