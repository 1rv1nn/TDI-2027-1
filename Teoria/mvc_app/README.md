# Pop Site MVC

Aplicación web MVC con Servlets Jakarta y JSP, basada en la aplicación de la carpeta `servlet`.

## Arquitectura

- `model/Cancion`: entidad del dominio con los datos de una canción.
- `dao/CancionDAO`: catálogo en memoria, alta, búsqueda y validación de canciones.
- `controller/PopController`: Servlet controlador. Atiende el catálogo, los detalles y el POST del formulario.
- `WEB-INF/views`: vistas JSP protegidas contra acceso directo.
- `css`, `images` y `html`: recursos estáticos de la interfaz.

El flujo principal es:

```text
GET /pop -> PopController -> CancionDAO -> WEB-INF/views/index.jsp
GET /pop?cancion=id -> PopController -> detalle HTML
GET /pop?filtro=madonna -> PopController -> CancionDAO -> index.jsp
POST /pop -> PopController -> CancionDAO -> redirección al listado
```

## Ejecutar

Requiere Java 17, Maven y Tomcat 10. El proyecto genera un WAR compatible con Jakarta Servlet 6.

```bash
mvn clean package
mvn cargo:run
```

La aplicación queda disponible en `http://localhost:8081/mvc-app/`.

