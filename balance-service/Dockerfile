FROM openjdk:8-jdk-alpine
EXPOSE 8079
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"]