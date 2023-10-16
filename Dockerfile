FROM openjdk:17-alpine

COPY target/domainHunt-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
