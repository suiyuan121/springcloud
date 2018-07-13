FROM java:8-jre
MAINTAINER Tomorrow jin.zhang <zhangjinntu@163.com>

ADD ./target/gateway.jar /app/
CMD ["java", "-Dserver.port=9031", "-jar", "/app/gateway.jar"]

EXPOSE 9031