# Use an official OpenJDK runtime as a base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container at /app
COPY target/AirportsManagement-1.0-SNAPSHOT.jar /app/

# Specify the command to run your application
CMD ["java", "-jar", "AirportsManagement-1.0-SNAPSHOT.jar"]
