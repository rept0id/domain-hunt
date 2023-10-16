build:
	sudo ./mvnw clean package;
	sudo docker-compose build;

build-run:
	sudo docker-compose down;
	sudo ./mvnw clean package;
	sudo docker-compose build;
	echo "Dont forget to run 'make stop' after, in order to stop server";
	sudo docker-compose up;

run:
	sudo docker-compose down;
	sudo docker-compose up;

stop:
	sudo docker-compose down;

