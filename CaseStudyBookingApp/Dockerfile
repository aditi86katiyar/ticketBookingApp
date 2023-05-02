FROM openjdk:11-jdk-slim
WORKDIR /casestudyApp
COPY target/BookingApp-0.0.1-SNAPSHOT.jar bookingApp.jar
EXPOSE 8089
CMD ["java", "-jar", "bookingApp.jar"]
