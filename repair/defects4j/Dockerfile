FROM ubuntu:trusty

ENV D4J_HOME /defects4j
ENV D4J_EDITOR diff -y -W $(( $(tput cols) - 2 ))

# Install basic utils and build envs.
RUN apt-get update -qq
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

RUN git clone https://github.com/rjust/defects4j 

RUN cd ${D4J_HOME} && ./init.sh

ENV PATH $D4J_HOME/framework/bin:$PATH