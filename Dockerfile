FROM tomcat:9.0.85-jdk17
COPY build/libs/app.war /usr/local/tomcat/webapps/
