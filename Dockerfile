FROM openjdk:11-jdk
FROM maven:3.6.3-jdk-11 AS MAVEN_TOOL_CHAIN

MAINTAINER ttt

COPY . /tmp/
WORKDIR /tmp/
RUN mvn package