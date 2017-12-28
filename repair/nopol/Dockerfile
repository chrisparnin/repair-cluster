FROM ubuntu:trusty

# Install basic utils and build envs.
RUN apt-get update -qqq
RUN apt-get install -y git
RUN apt-get install -y subversion
RUN apt-get install -y perl
RUN apt-get install -y unzip
RUN apt-get install -y libdbi-perl
RUN apt-get install -y libtext-csv-perl
RUN apt-get install -y libdbd-csv-perl
RUN apt-get install -y debconf
RUN apt-get install -y curl
RUN apt-get install -y software-properties-common

# Oracle took down jdk7 tar.gz, download sketchy version of jdk 7
RUN curl -o /tmp/jdk-7u80-linux-x64.tar.gz http://ftp.osuosl.org/pub/funtoo/distfiles/oracle-java/jdk-7u80-linux-x64.tar.gz
RUN sudo add-apt-repository ppa:webupd8team/java
RUN sudo apt-get update

# point to download.
RUN echo oracle-java7-installer oracle-java7-installer/local select /tmp | sudo /usr/bin/debconf-set-selections
#RUN mkdir -p /var/cache/oracle-jdk7-installer/ && mv /tmp/jdk-7u80-linux-x64.tar.gz /var/cache/oracle-jdk7-installer/

# Automatically select the Oracle License
RUN echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections
RUN apt-get install oracle-java7-installer -y --force-yes

RUN apt-get install -y maven

RUN git clone https://github.com/SpoonLabs/CoCoSpoon.git
RUN cd /CoCoSpoon && mvn clean install

RUN git clone https://github.com/SpoonLabs/nopol.git

RUN add-apt-repository ppa:webupd8team/java
RUN apt-get update

RUN echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections

RUN apt-get install -y oracle-java8-installer


RUN cd /nopol/nopol && mvn package -DskipTests

RUN cd /nopol/test-projects && mvn test -DskipTests 

# Z3
RUN git clone https://github.com/Z3Prover/z3
RUN apt-get install -y python build-essential
RUN cd /z3/ && python scripts/mk_make.py
RUN cd /z3/build && make && make install

#RUN java -jar nopol.jar \
#-s src/main/java/ \
#-c target/classes:target/test-classes:/home/ubuntu/.m2/repository/junit/junit/4.11/junit-4.11.jar:/home/<user>/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar \
#-t symbolic_examples.symbolic_example_1.NopolExampleTest \
#-p ../nopol/lib/z3/z3_for_linux
