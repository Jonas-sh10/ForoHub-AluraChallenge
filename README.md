## <h1 align="center"><span id="título-portada">Foro Hub: Alura Challenge Java</span> </h1>
___
![Imagen](https://img.freepik.com/premium-vector/illustrations-flat-design-concept-video-conference-online-meeting-work-form-home-call-live-video_71983-2124.jpg?w=900)

___
## <span id="insignias">Insignias</span>
![Proyecto](https://img.shields.io/badge/Status-Main_Functions_Finished-brightgreen)
![IDE](https://img.shields.io/badge/IDE-Intellij_IDEA-ff69b4)
![Java JDK](https://img.shields.io/badge/Java_JDK-v17.0-1e90ff)
![Project](https://img.shields.io/badge/Project-Maven-ff4500)
![Spring_Boot](https://img.shields.io/badge/Spring_Boot-v3.3.0-6a5acd)
![MySQL](https://img.shields.io/badge/MySQL-v8.0-ffa500)

___
## <span id="índice">Índice</span>

* [Título e imagen de portada](#título-portada)
* [Insignias](#insignias)
* [Índice](#índice)
* [Descripción del proyecto](#descripción-del-proyecto)
* [Características de la aplicación](#características-de-la-aplicación)
* [Autenticación y Seguridad](#autenticación)
* [Tecnologías utilizadas](#tecnologías-utilizadas)
* [Acceso al proyecto](#acceso-al-proyecto)

---
## <span id="descripción-del-proyecto">Descripción del proyecto</span>
<p align="justify">
ForoHub es un sistema de gestión de foros diseñado para facilitar la interacción entre estudiantes, profesores y administradores de Alura Latam. Permite a los usuarios crear, leer, actualizar y eliminar tópicos de discusión, y ofrece un entorno seguro y eficiente para la colaboración y el aprendizaje.
</p>

---
## <span id="características-de-la-aplicación">Principales funciones de la aplicación</span>
<p align="justify">
    <span style="color:#1E90FF;"><strong>1. Crear un nuevo tópico:</strong></span> Permite a los usuarios crear un nuevo tópico en el foro.<br>
</p>
<p align="justify">
    <span style="color:#32CD32;"><strong>2. Mostrar todos los tópicos creados:</strong></span> Lista todos los tópicos disponibles en el foro.<br>

- `Busca todos los topicos`<br>
- `Busca topico por curso y año`<br>
- `Busca topico por id`<br>
</p>
<p align="justify">
    <span style="color:#8A2BE2;"><strong>3. Actualizar un tópico:</strong></span> Permite a los usuarios actualizar la información de un tópico existente.<br>
</p>
<p align="justify">
    <span style="color:#FFA500;"><strong>4. Eliminar un tópico:</strong></span> Permite a los usuarios eliminar un tópico del foro.<br>
</p>

---
## <span id="autenticación">Autenticación y Seguridad</span>
<p align="justify">
    <span style="color:#1E90FF;"><strong>1. Dependencias:</strong></span> Asegúrate de agregar las siguientes dependencias en tu archivo `pom.xml`:<br>

- `Spring Security`<br>
- `JWT.IO`<br>
- `SpringDoc OpenAPI`<br>
</p>
<p align="justify">
    <span style="color:#32CD32;"><strong>2. Configuración de Seguridad:</strong></span> La configuración de seguridad se realiza en la clase `SecurityConfigurations` que define las políticas de acceso y la protección de las rutas de la API.<br>
</p>
<p align="justify">
    <span style="color:#FF6347;"><strong>3. Controlador de Autenticación:</strong></span> Creamos un controlador de autenticación que maneja las solicitudes de inicio de sesión. Los usuarios pueden autenticarse enviando sus credenciales (email y contraseña) y, si son válidas, reciben un token JWT.<br>
</p>
<p align="justify">
    <span style="color:#8A2BE2;"><strong>4. Generación y Validación de Token:</strong></span> Implementamos un servicio `TokenService` que se encarga de generar y validar los tokens JWT. Este token es utilizado para autenticar las solicitudes posteriores de los usuarios.<br>
</p>
<p align="justify">
    <span style="color:#FFA500;"><strong>5. Filtro de Autenticación JWT:</strong></span> Para asegurar que cada solicitud esté autenticada, configuramos un filtro de autenticación JWT que valida el token incluido en las cabeceras de las solicitudes.<br>
</p>

---
## <span id="tecnologías-utilizadas">Tecnologías utilizadas</span>

### Principales requisitos
<p align="justify">

1. **Java JDK**: Versión 17 o superior
    - [Download the Latest Java LTS Free](https://www.oracle.com/java/technologies/javase-downloads.html)
</p>
<p align="justify">

2. **Maven**: Versión 4 o superior para la gestión de dependencias y construcción del proyecto.
    - [Apache Maven](https://maven.apache.org/download.cgi)
</p>
<p align="justify">

3. **Spring Boot**: Versión 3.3.0.
    - [Spring Initializr](https://start.spring.io/)
</p>
<p align="justify">

4. **MySQL**: Versión 8.0 o superior como base de datos relacional.
    - [MySQL Installer](https://dev.mysql.com/downloads/installer/)
</p>
<p align="justify">

5. **IDE**: IntelliJ IDEA para el desarrollo integrado del proyecto.
    - [JetBrains IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/download/)
</p>

### Dependencias del proyecto
<p align="justify">

- <span style="color:#1E90FF;"><strong>Spring Web</strong></span>: Para construir la API REST.<br>
- <span style="color:#32CD32;"><strong>Spring Data JPA</strong></span>: Para la integración con la capa de persistencia.<br>
- <span style="color:#FF6347;"><strong>MySQL Driver</strong></span>: Para la conexión con la base de datos MySQL.<br>
- <span style="color:#8A2BE2;"><strong>Lombok</strong></span>: Para reducir el código boilerplate.<br>
- <span style="color:#FFA500;"><strong>Spring Boot DevTools</strong></span>: Para mejorar el ciclo de desarrollo.<br>
- <span style="color:#00BFFF;"><strong>Flyway Migration</strong></span>: Para la gestión de migraciones de la base de datos.<br>
- <span style="color:#FF1493;"><strong>Validation</strong></span>: Para la validación de datos.<br>
- <span style="color:#9370DB;"><strong>Spring Security</strong></span>: Para la autenticación y autorización.<br>
- <span style="color:#32CD32;"><strong>SpringDoc OpenAPI</strong></span>: Para la generación automática de documentación OpenAPI.<br> Enlace para poder usarlo en un navegador web previamente levantado la aplicacion:
   ```springdoc
   http://localhost:8080/swagger-ui.html
   ```
  </p>


### Configuración de la base de datos
<p align="justify">

Para configurar la conexión a la base de datos MySQL, añade las siguientes propiedades<strong>(localhost, nombre de la base de datos, usuario y la contraseña)</strong> a tu archivo `application.properties` en tu proyecto Spring Boot:
</p>

```properties
spring.datasource.url = jdbc:mysql://${DB_HOST}/${DB_NAME}
spring.datasource.username = ${DB_USER}
spring.datasource.password = ${DB_PASSWORD}
```

---
## <span id="acceso-al-proyecto">Acceso al proyecto</span>
-  Clonar el repositorio
```bash
git clone https://github.com/Jonas-sh10/ForoHub-AluraChallenge.git
```

