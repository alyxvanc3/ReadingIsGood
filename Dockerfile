ROM openjdk:17-jdk-alpine
MAINTAINER aysenur.kilic
COPY target/readingIsGood-0.0.1-SNAPSHOT.jar readingIsGood-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/readingIsGood-0.0.1-SNAPSHOT.jar"]