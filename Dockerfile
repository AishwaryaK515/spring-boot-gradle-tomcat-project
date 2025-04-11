FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG WAR_FILE=build/libs/app.war
COPY ${WAR_FILE} app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.war"]

