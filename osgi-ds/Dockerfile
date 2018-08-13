FROM ubuntu:16.04
MAINTAINER avan.resul@gmail.com
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

ENV KARAF_VERSION=4.2.0 \
    JAVA_HOME="/usr/lib/jvm/java-8-oracle"

RUN apt-get update && \
    apt-get install -y \
        software-properties-common \
        build-essential \
        wget \
        vim \
        nano \
        iputils-ping \
        net-tools \
    && \

    echo "======================== JAVA 8" && \
    echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
    add-apt-repository ppa:webupd8team/java && \
    apt-get update && \
    apt-get install -y oracle-java8-installer && \

    echo "======================== INSTALL and CONFIGURE SSH" && \
    apt-get install -y \
            openssh-server \
            sshpass \
            && \
    mkdir /var/run/sshd && \
    echo 'root:1234' | chpasswd && \
    sed -i 's/PermitRootLogin/#PermitRootLogin/' /etc/ssh/sshd_config && \
    echo "PermitRootLogin yes" >> /etc/ssh/sshd_config && \
    update-rc.d ssh defaults


RUN mkdir /opt/karaf; \
    wget http://ftp.itu.edu.tr/Mirror/Apache/karaf/${KARAF_VERSION}/apache-karaf-${KARAF_VERSION}.tar.gz; \
    tar --strip-components=1 -C /opt/karaf -xzvf apache-karaf-${KARAF_VERSION}.tar.gz; \
    rm apache-karaf-${KARAF_VERSION}.tar.gz; \
    mkdir /deploy; \
    sed -i 's/^\(felix\.fileinstall\.dir\s*=\s*\).*$/\1\/deploy/' /opt/karaf/etc/org.apache.felix.fileinstall-deploy.cfg
EXPOSE 22 1099 8101 44444
CMD ["/usr/sbin/sshd", "-D"]