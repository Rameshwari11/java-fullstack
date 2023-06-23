FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/api-gateway-server.jar api-gateway-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /api-gateway-server.jar"]