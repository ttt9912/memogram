FROM openjdk:11-jdk
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN

MAINTAINER ttt

COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

ADD target/*.jar app.jar
ENV JAVA_OPTS="-Dserver.port=$PORT -Djava.security.egd=file:/dev/./urandom"
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]
