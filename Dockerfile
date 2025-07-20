# Use a lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
VOLUME /tmp

# Copy the JAR file into the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]