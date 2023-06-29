# Build stage
FROM adoptopenjdk:11-jdk-hotspot AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY gradlew ./
COPY gradlew.bat ./
RUN chmod +x gradlew          # Set executable permissions for gradlew

# Install Gradle
RUN apt update && apt install -y gradle

# Build the project
RUN ./gradlew clean build --no-daemon

# Package stage
FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
