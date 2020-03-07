FROM openjdk:11-jdk
VOLUME /tmp
ADD target/*.jar app.jar
ENV JAVA_OPTS="-Dserver.port=$PORT -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom"
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]