FROM openjdk:17-jdk-alpine
MAINTAINER aysenur.kilic
COPY target/readingIsGood-0.0.1-SNAPSHOT.jar readingIsGood.jar
ENTRYPOINT ["java","-jar","/readingIsGood.jar"]