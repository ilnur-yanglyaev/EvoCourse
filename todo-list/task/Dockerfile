FROM openjdk:17
VOLUME /tmp
COPY target/task-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]