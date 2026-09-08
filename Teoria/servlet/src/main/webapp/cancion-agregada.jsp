<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Canción agregada</title>
  <link rel="stylesheet" href="css/estilo1.css">
</head>
<body class="song-form-page">
  <main class="song-form">
    <h1>Canción agregada</h1>
    <p><strong>Artista:</strong> ${artista}</p>
    <p><strong>Título:</strong> ${titulo}</p>
    <p><strong>Álbum:</strong> ${album}</p>
    <a class="back-link" href="canciones.jsp">Agregar otra canción</a>
    <br>
    <a class="back-link" href="pop">Volver al inicio</a>
  </main>
</body>
</html>
