FROM openjdk:11-jdk
FROM maven:3.6.3-jdk-11 AS MAVEN_TOOL_CHAIN

MAINTAINER ttt

COPY . /tmp/
WORKDIR /tmp/
RUN mvn package

ADD /tmp/memogram-apps/memogram-app-postgres/target/*.jar app.jar

ENV JAVA_OPTS="-Dserver.port=$PORT -Djava.security.egd=file:/dev/./urandom"
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]
