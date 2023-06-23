FROM openjdk:8-jdk-alpine
EXPOSE 9061
ADD target/skill-server.jar skill-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /skill-server.jar"]