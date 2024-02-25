Docker commands

Dockerfile 

FROM openjdk

WORKDIR /app

COPY . /app

EXPOSE 8080

CMD ["java","-jar","employee-api-0.0.1-SNAPSHOT.jar"]




build the image in docker
docker build -t testapi:latest .

Run the docker in cmd mode i.e cmd logs show
docker run -p  8080:8080 testapi:latest

Run the docker in detached mode i.e cmd logs wont show
docker run -d -p  8080:8080 testapi:latest

