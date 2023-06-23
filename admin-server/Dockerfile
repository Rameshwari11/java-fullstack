FROM openjdk:8-jdk-alpine
EXPOSE 9801
ADD target/admin-server.jar admin-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /admin-server.jar"]