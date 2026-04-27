# 📦 Asset Management API (ERP)

Backend desarrollado con **Quarkus** para la gestión centralizada de activos. Este proyecto demuestra la implementación de estándares de industria en arquitecturas Java modernas, enfocado en la mantenibilidad y el desacoplamiento.

## 🚀 Tecnologías y Herramientas
* **Java 21**
* **Quarkus**: Framework Supersonic Subatomic Java.
* **Hibernate Panache**: Capa de persistencia sobre JPA.
* **MySQL**: Base de datos relacional.
* **Jakarta Validation**: Reglas de integridad en la capa de entrada.
* **DTO Pattern**: Desacoplamiento de la API y la persistencia.
* **Swagger/OpenAPI**: Documentación interactiva.

## 🛠️ Características Principales
- **Arquitectura Limpia**: Separación estricta entre Entidades y DTOs.
- **Auditoría Nativa**: Gestión automática de `createdAt` y `updatedAt` mediante ciclos de vida de JPA.
- **Manejo Global de Excepciones**: Respuestas estandarizadas para errores 404 y 400 mediante ExceptionMappers.
- **Validación Robusta**: Contratos de API con validaciones de campos obligatorios y valores positivos.

## 🔧 Configuración y Ejecución

### Requisitos
- JDK 21+
- Maven 3.9+
- MySQL Server

### Ejecución en modo Desarrollo
```bash
./mvnw quarkus:dev
