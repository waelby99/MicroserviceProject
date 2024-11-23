FROM openjdk:17
EXPOSE 8075
ADD target/ErekaServer-0.0.1-SNAPSHOT.jar ErekaServer.jar
ENTRYPOINT ["java", "-jar", "ErekaServer.jar"]