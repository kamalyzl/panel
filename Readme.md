# 🧾 Spring Boot Store API

API REST para gestionar productos, clientes y facturas, construida con Spring Boot + PostgreSQL.

---

## 🚀 Despliegue en Railway

1. Sube tu proyecto a un repositorio en GitHub.
2. Entra a [https://railway.app](https://railway.app) e inicia sesión.
3. Crea un nuevo proyecto desde tu repo.
4. Railway detectará tu app Java. Agrega las siguientes variables en la pestaña "Variables":

```
PORT=8080
SPRING_DATASOURCE_URL=jdbc:postgresql://... (Railway te la da)
SPRING_DATASOURCE_USERNAME=...
SPRING_DATASOURCE_PASSWORD=...
```

5. Railway generará automáticamente una URL para probar tu API.

---

## 💻 Ejecutar localmente con Docker

### Requisitos
- Docker y Docker Compose
- JDK 17
- Gradle instalado

### 1. Levantar PostgreSQL
```bash
docker-compose up -d
```

### 2. Configura tu `application-local.properties`
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/storedb
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

### 3. Ejecutar la app con perfil local
```bash
./gradlew bootRun --args='--spring.profiles.active=local'
```

---

## 🧪 Probar endpoints

### Crear cliente
```bash
curl -X POST http://localhost:8080/api/customers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Lucía",
    "lastname": "Fernández",
    "dni": "12345678",
    "address": "Av. Perú 123",
    "numberPhone": "987654321",
    "email": "lucia.fernandez@example.com"
  }'
```

### Crear producto
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop Dell XPS",
    "description": "Ultrabook",
    "totalQuantity": 10,
    "availableQuantity": 8,
    "category": "Electronics",
    "price": 3999.99
  }'
```

---

## 📂 Estructura del proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/store/panel/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── entity/
│   │       ├── mapper/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
│       ├── application.properties
│       └── application-local.properties
```

---

## 🛠️ Compilar y generar JAR
```bash
./gradlew clean build
```
El archivo JAR se generará en `build/libs/panel-0.0.1-SNAPSHOT.jar`

---

## 🐳 Docker (producción)
```bash
docker build -t spring-panel .
docker run -p 8080:8080 spring-panel
```

---

## 📄 Licencia
Este proyecto es libre de usar con fines educativos y de prueba.