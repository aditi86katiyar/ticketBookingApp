FROM openjdk:8-jdk-slim
WORKDIR /casestudyApp
COPY target/BookingApp-0.0.1-SNAPSHOT.jar bookingApp.jar
EXPOSE 8080
CMD ["java", "-jar", "bookingApp.jar"]
