<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Agregar canción</title>
  <link rel="stylesheet" href="css/estilo1.css">
</head>
<body class="song-form-page">
  <main class="song-form">
    <h1>Agregar una canción</h1>

    <form action="pop" method="post">
      <label for="artista">Artista</label>
      <select id="artista" name="artista" required>
        <option value="">Selecciona un artista</option>
        <option value="Michael Jackson">Michael Jackson</option>
        <option value="Madonna">Madonna</option>
      </select>

      <label for="titulo">Título de la canción</label>
      <select id="titulo" name="titulo" required>
        <option value="">Selecciona un título</option>
        <option value="Dangerous">Dangerous</option>
        <option value="Into The Groove">Into The Groove</option>
      </select>

      <label for="album">Álbum</label>
      <select id="album" name="album" required>
        <option value="">Selecciona un álbum</option>
        <option value="Dangerous">Dangerous</option>
        <option value="Holiday">Holiday</option>
      </select>

      <button type="submit">Agregar canción</button>
    </form>

    <a class="back-link" href="pop">Volver al inicio</a>
  </main>
</body>
</html>
