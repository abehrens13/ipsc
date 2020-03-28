FROM openjdk:8-jre-alpine
COPY target/ipsc-0.0.4-SNAPSHOT.war /usr/app/
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/usr/app/ipsc-0.0.4-SNAPSHOT.war"]
