# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot JAR file into the container
COPY target/your-spring-boot-app.jar app.jar

# Expose a port that the application will run on (replace 8080 with your app's port)
EXPOSE 8081

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]