
Foro Hub - Practicando Spring Framework
Descripción
Este proyecto es una API REST para un foro académico en línea donde los estudiantes pueden interactuar, hacer preguntas y obtener respuestas a sus dudas. Fue desarrollado como parte de un challenge para practicar Spring Framework.

Características
Gestión de usuarios: Permite el registro, autenticación (con JWT) y gestión de perfiles de usuario.
Gestión de cursos: Permite la creación y gestión de cursos académicos.
Foro: Permite la creación de tópicos, respuestas a tópicos y la gestión del estado de los mismos (abierto/cerrado).
Seguridad: Implementa Spring Security para la autenticación y autorización de usuarios.
Persistencia: Utiliza Spring Data JPA para la persistencia de datos en una base de datos MySQL.
Migración de base de datos: Utiliza Flyway para la gestión de versiones de la base de datos.
Validación: Utiliza Spring Boot Validation para la validación de datos de entrada.
Mapeo de objetos: Utiliza mappers para la conversión entre entidades y DTOs.
Tecnologías utilizadas
Spring Boot
Spring Security
Spring Data JPA
MySQL
Flyway
JWT (Java Web Token)
Maven
Lombok
Cómo ejecutar el proyecto
Clonar el repositorio: git clone https://github.com/tu_usuario/Foro-Hub.git
Configurar la base de datos:
Crear una base de datos MySQL llamada forohub.
Actualizar las credenciales de la base de datos en el archivo application.properties.
Ejecutar la aplicación: mvn spring-boot:run
