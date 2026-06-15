# GreenBite - Microservicio Productos

## Descripción

Microservicio encargado de administrar el catálogo de productos de la plataforma GreenBite.

Este servicio implementa una arquitectura REST utilizando Spring Boot y MongoDB como sistema de persistencia. Forma parte de la arquitectura de microservicios del proyecto GreenBite y se comunica con el frontend a través del BFF (Backend For Frontend).

---

## Tecnologías Utilizadas

* Java 17
* Spring Boot 3.4.1
* Spring Data MongoDB
* MongoDB
* Spring Validation
* Swagger / OpenAPI
* JUnit 5
* Mockito
* JaCoCo
* Maven

---

## Arquitectura Implementada

El microservicio utiliza los siguientes patrones de diseño:

* DTO Pattern
* Service Layer Pattern
* Repository Pattern
* Exception Handler Pattern
* Database per Service

---

## Persistencia

Este microservio utiliza MongoDB como base de datos NoSQL.

Base de datos utilizada:

```text
MongoDB
```

Colección principal:

```text
productos
```

---

## Endpoints Disponibles

### Obtener todos los productos

```http
GET /productos
```

### Obtener producto por ID

```http
GET /productos/{id}
```

### Registrar producto

```http
POST /productos
```

Ejemplo:

```json
{
  "nombre": "Manzana",
  "precio": 1000,
  "stock": 5
}
```

### Eliminar producto

```http
DELETE /productos/{id}
```

---

## Documentación Swagger

Swagger UI disponible en:

```text
http://localhost:8081/swagger-ui/index.html
```

---

## Ejecución del Proyecto

### Requisitos

* Java 17
* Maven
* MongoDB

### Ejecutar MongoDB mediante Docker

```bash
docker compose up -d
```

### Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La aplicación quedará disponible en:

```text
http://localhost:8081
```

---

## Pruebas Unitarias

Ejecutar pruebas:

```bash
mvn test
```

Resultado actual:

```text
Tests ejecutados: 5
Fallos: 0
Errores: 0
```

---

## Cobertura de Código

Generar reporte JaCoCo:

```bash
mvn clean test
```

Reporte generado en:

```text
target/site/jacoco/index.html
```

Cobertura obtenida:

```text
62%
```

---

## Estructura del Proyecto

```text
src
├── controllers
├── dtos
├── exceptions
├── models
├── repositories
└── services
```

---

## INTEGRANTES

- Fernanda Paredes
- Martina Flores
- Alexander Torres

Proyecto desarrollado para la asignatura Desarrollo FullStack III utilizando arquitectura de microservicios, persistencia independiente por servicio y documentación OpenAPI.
