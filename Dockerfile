#Maven image
FROM openjdk:8-jdk-alpine

ADD target/*.jar test-jenkins.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "test-jenkins.jar"]