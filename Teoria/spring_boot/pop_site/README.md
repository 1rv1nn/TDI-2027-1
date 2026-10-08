# Pop Site Versión 1.3

## Ejecutar con Docker

Desde la raíz del proyecto, ejecuta:

```bash
docker compose build
docker compose up -d
```

Si se desea revisar los logs

```
docker compose logs -f app
```


Esto levanta:
- PostgreSQL en el servicio `db`
- la aplicación Spring Boot en el servicio `app`

La app quedará disponible en:

```text
http://localhost:8080/app/
```

### Revisar si se crean las tablas

```bash
docker compose exec db psql -U popsite -d popsite -c "SELECT * FROM canciones;"
```

## Detener la aplicación

```bash
docker compose down
```
## Detener la aplicación eliminado los volúmenes asociados

```bash
docker compose down -v
```


## Observaciones

Si se modifica el PopController es necesario recrear el contenedor sin reconstruir la imagen.

```
docker compose down
```

```
docker compose up -d --force-recreate app
```

Con ello se esta reutilizando la imagen de `Meaven`.
