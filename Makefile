build:
	./mvnw clean package;

run:
	java -jar target/domainHunt.jar

build-run: build run
