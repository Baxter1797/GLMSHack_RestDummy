# Use a smaller Maven image for building the application
FROM maven:3.9.8-amazoncorretto-17-al2023 AS build

WORKDIR /app

# Copy only the POM file first to download dependencies
COPY pom.xml ./

# Download dependencies. This step is cached unless pom.xml changes
RUN mvn dependency:go-offline

# Copy the rest of the application source
COPY src ./src

# Build the application
RUN mvn clean package

# Use a smaller OpenJDK image for the runtime image
FROM openjdk:23-ea-17-jdk-slim

WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar ./dummyRestGLMS.jar

# Expose the port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "dummyRestGLMS.jar"]