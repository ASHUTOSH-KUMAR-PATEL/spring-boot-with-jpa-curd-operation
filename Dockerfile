FROM openjdk:17
EXPOSE 8080
ADD target/devops-integration.jar devops-integration
ENTRYPOINT ["java", ",-jar", "devops-integration.jar"]