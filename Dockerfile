FROM openjdk:8-jre-alpine
WORKDIR /usr/app
COPY target/ipsc-0.0.2-SNAPSHOT.war app.war 
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "app.war"]