FROM openjdk:17-jdk-slim
WORKDIR /casestudyApp
COPY target/CasestudyApp-0.0.1-SNAPSHOT.jar theatreapp.jar
EXPOSE 8080
CMD ["java", "-jar", "theatreapp.jar"]
