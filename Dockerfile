FROM alpine:3.14
ARG JAR_FILE=target/exchanger-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} exchanger.jar
ENTRYPOINT [“java","-jar","exchanger.jar"]