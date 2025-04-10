FROM openjdk:20
COPY target/worker-1.0-SNAPSHOT-jar-with-dependencies.jar /app/worker.jar
WORKDIR /app
CMD ["java", "-jar", "worker.jar"]
