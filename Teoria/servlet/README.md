# Pop Site con Servlet

## Requerimientos

- Java JDK 17 o superior.
- Apache Maven 3.8 o superior.
- Visual Studio Code.
- Puerto `8080` libre.



## Comprobar herramientas

Desde una terminal, ejecuta:

```
java -version
mvn -version
```

Java debe mostrar la version 17 o superior y Maven debe estar disponible en el `PATH`.

## Levantar la aplicacion

Abre una terminal en la carpeta del proyecto:

Ejecuta:

```
mvn clean package cargo:run
```

La aplicacion estara disponible en:

```
http://localhost:8080/app/
```

## URLs dinamicas

El servlet `PopServlet` atiende la ruta `/pop`:

```text
http://localhost:8080/app/pop
```

Puedes cambiar entre commits para revisar un servlet básico y uno con URLs dinamicas.
