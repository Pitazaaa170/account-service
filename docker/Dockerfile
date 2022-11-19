FROM openjdk:17-jdk-slim
ADD target/account-service-*.jar account-service.jar
ENTRYPOINT ["java", "-jar","account-service.jar"]
EXPOSE 8080