FROM openjdk:8
MAINTAINER jeffersonpinheiro
WORKDIR /opt/app

ARG JAR_FILE=target/tour-0.0.1-SNAPSHOT.jar
COPY${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app-jar"]