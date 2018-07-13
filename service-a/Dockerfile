FROM java:8-jre
MAINTAINER Tomorrow jin.zhang <zhangjinntu@163.com>

ADD ./target/service-a.jar /app/
CMD ["java", "-Dserver.port=8080", "-jar", "/app/service-a.jar"]

EXPOSE 8080