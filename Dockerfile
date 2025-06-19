# Etapa 1: Build con Gradle
FROM gradle:8.5-jdk21 AS builder
WORKDIR /home/app
COPY --chown=gradle:gradle . .
RUN chmod +x ./gradlew
RUN ./gradlew build -x test --no-daemon

# Etapa 2: Imagen final con Java
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /home/app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
