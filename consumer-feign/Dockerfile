FROM java:8-jre
MAINTAINER Tomorrow jin.zhang <zhangjinntu@163.com>

ADD ./target/consumer-feign.jar /app/
CMD ["java", "-Dserver.port=8080", "-jar", "/app/consumer-feign.jar"]

EXPOSE 8080