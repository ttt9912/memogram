FROM openjdk:11-jdk
MAINTAINER ttt
ADD target/*.jar app.jar

RUN bash -c 'touch /app.jar'
ENV JDBC_DATABASE_URL="jdbc:postgresql://localhost:5432"
ENV JDBC_DATABASE_USERNAME="docker"
ENV JDBC_DATABASE_PASSWORD="docker"
ENV PORT=$PORT
COPY docker-run.sh /run.sh
RUN chmod +x /run.sh
CMD ["/run.sh"]

ENV JAVA_OPTS="-Dserver.port=$PORT -Djava.security.egd=file:/dev/./urandom"
CMD [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]