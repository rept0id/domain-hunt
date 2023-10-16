FROM adoptopenjdk/openjdk17

COPY target/domainHunt-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
