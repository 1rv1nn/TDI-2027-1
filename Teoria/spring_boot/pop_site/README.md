# Pop Site Versión 1.3

## Ejecutar con Docker

Desde la raíz del proyecto, ejecuta:

```bash
docker compose build
docker compose up -d
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