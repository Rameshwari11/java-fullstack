FROM openjdk:8-jdk-alpine
EXPOSE 9062
ADD target/associate-server.jar associate-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /associate-server.jar"]