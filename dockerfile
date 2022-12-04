FROM openjdk
COPY target/xmltohtm-1.0-SNAPSHOT.jar xmltohtm-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/xmltohtm-1.0-SNAPSHOT.jar"]