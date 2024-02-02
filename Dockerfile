FROM cloudnativek8s/apache-hive:3.1.3-v1.0.18
ARG HIVE_BIN_VERSION="3.1.3"
ARG HADOOP_BIN_VERSION="3.3.6"
ENV HIVE_BIN_VERSION=${HIVE_BIN_VERSION}
ENV HADOOP_BIN_VERSION=${HADOOP_BIN_VERSION}

COPY hive-v2/ /tmp/hive-v2/

RUN /tmp/hive-v2/setup.sh

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV HADOOP_HOME /opt/app/hadoop-${HADOOP_BIN_VERSION}
ENV HIVE_HOME /opt/app/apache-hive-${HIVE_BIN_VERSION}-bin
ENV PATH $HADOOP_HOME/bin:$HIVE_HOME/bin:$JAVA_HOME/bin:$PATH

WORKDIR /opt/app/work

CMD ["./hive-start.sh"]

