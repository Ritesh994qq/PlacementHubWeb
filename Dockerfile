FROM tomcat:11.0-jdk17-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/PlacementHubWeb-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]