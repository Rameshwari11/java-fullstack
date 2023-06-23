FROM openjdk:8-jdk-alpine
EXPOSE 8761
ADD target/eureka-server.jar eureka-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /eureka-server.jar"]