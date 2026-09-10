# Aplicación con Spring Boot

## Configuración del Entorno

  - Mediante vsCode instalar las extensiones `Extension Pack for Java` y `Spring Boot Extension Pack`
  - Generar el proyecto con Spring Initializr
  - Seleccionar dependencia `Spring Web (spring-boot-starter-web).`

## Levantamiento 

  Desde el directorio donde se ubica archivo principal, el que tiene la anotación @SpringBootApplication

  - Utilizando el comando:

    `./mvnw spring-boot:run`

   Abre tu navegador o una pestaña de pruebas HTTP y accede a:

  - http://localhost:8080/ 

## Depuración  

  `./mvnw spring-boot:run -e`

  `./mvnw spring-boot:run -X`