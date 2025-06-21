# 🧾 Panel de Facturación - API REST con Spring Boot

Este proyecto es un sistema básico de gestión de productos, clientes y facturas desarrollado con **Spring Boot**, **PostgreSQL**, **Docker** y **Gradle**.

---

## 🚀 Requisitos Previos

- Java 21 (JDK instalado)
- Gradle 8.x
- Docker y Docker Compose (para base de datos local)
- IDE (IntelliJ, VSCode, etc.)

---

## ⚙️ Instalación y Ejecución en Local

### 1. Clona el repositorio

 
```bash
git clone https://github.com/tu-usuario/tu-repo.git
cd tu-repo
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

## 🧪 Colección Postman

Puedes importar esta colección en Postman para probar los endpoints:

👉 [Descargar colección Postman](./Panel.postman_collection.json)

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
 

 
---

## 📄 Licencia
Este proyecto es libre de usar con fines educativos y de prueba.