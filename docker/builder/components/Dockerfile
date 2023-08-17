
FROM openjdk:17-jdk-alpine
WORKDIR /app
ARG BUILD_PATH
COPY ./${BUILD_PATH}/build/libs/*.jar app.jar
EXPOSE 8080
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]