# 1. Imagen oficial con Java 21 JDK
FROM eclipse-temurin:21-jdk-alpine

# 2. Directorio de trabajo dentro del contenedor
WORKDIR /app

# 3. Copiar el archivo JAR generado (ajusta el nombre si cambia)
COPY build/libs/panel-0.0.1-SNAPSHOT.jar app.jar

# 4. Expón el puerto (por defecto 8080 en Spring Boot)
EXPOSE 8080

# 5. Comando para iniciar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
