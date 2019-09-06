FROM openjdk:8-jre-alpine
MAINTAINER jason <songshun.ss@antfin.com>

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

ADD target/dubbo-samples-echo-server-1.0-SNAPSHOT.jar /home/admin/release/dubbo-samples-echo-server-1.0-SNAPSHOT.jar

ADD start.sh /home/admin/release/start.sh

RUN chmod a+x /home/admin/release/start.sh

ENTRYPOINT ["/bin/sh", "/home/admin/release/start.sh"]
