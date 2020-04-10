FROM openjdk:8-jre-alpine
COPY target/ipsc-0.0.5-SNAPSHOT.war /usr/app/
EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/usr/app/ipsc-0.0.5-SNAPSHOT.war"]
