FROM openjdk:8-jdk-alpine
EXPOSE 8087
ADD target/hello-world-docker-service.jar hello-world-docker-service.jar
ENTRYPOINT ["sh", "-c", "java -jar /hello-world-docker-service.jar"]