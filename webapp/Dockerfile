from openjdk:8-alpine

copy target/webapp-1.0-SNAPSHOT.jar /opt/
copy test.yaml /opt/

CMD ["java", "-jar", "/opt/webapp-1.0-SNAPSHOT.jar", "server", "/opt/test.yaml"]