#EUREKA SERVER DOCKERFILE
FROM eclipse-temurin:17-jre-alpine
ARG BUILD_PATH
COPY ./${BUILD_PATH}/build/libs/*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]