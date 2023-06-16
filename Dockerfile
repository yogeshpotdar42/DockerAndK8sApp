FROM --platform=linux/amd64  maven

USER root


WORKDIR /app

COPY . /app

RUN  mvn clean install -DskipTests

WORKDIR /app/target


RUN mv  DockerAndK8sApp-0.0.1-SNAPSHOT.jar DockerAndK8sApp.jar
