# Aplicación con Spring Boot

## Configuración del Entorno

  - Mediante vsCode instalar las extensiones `Extension Pack for Java` y `Spring Boot Extension Pack`
  - Generar el proyecto con Spring Initializr
  - Seleccionar dependencia `Spring Web (spring-boot-starter-web).`

## Levantamiento 

  Desde el directorio raiz

  - Utilizando el comando:

    `./mvnw spring-boot:run`

  - o el comando:
  
    `./mvnw clean spring-boot:run   `

 Tambien puedes levantar la aplicación desde archivo principal, el que tiene la anotación @SpringBootApplication   


   Abre tu navegador o una pestaña de pruebas HTTP y accede a:

  - http://localhost:8080/ 

## Depuración  

  `./mvnw spring-boot:run -e`

  `./mvnw spring-boot:run -X`

## Arquitectura en Capas

Separación de responsabilidades en niveles independientes del archivo EdadController.java 
Commit `4a0eab4`

  - Controller
  - Service
  - Repository