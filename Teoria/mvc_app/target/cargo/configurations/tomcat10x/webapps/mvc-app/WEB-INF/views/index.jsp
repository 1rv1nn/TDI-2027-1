<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Catálogo Pop</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo1.css">
</head>
<body>
  <header class="header-container">
    <a class="header-link" href="${pageContext.request.contextPath}/html/michael_jackson.html"><div class="header-section"><img src="${pageContext.request.contextPath}/images/king_pop.jpg" alt="King of pop" class="header-img"><span class="header-title">King of pop</span></div></a>
    <a class="header-link" href="${pageContext.request.contextPath}/html/madonna.html"><div class="header-section"><img src="${pageContext.request.contextPath}/images/queen_pop.jpg" alt="Queen of pop" class="header-img"><span class="header-title">Queen of pop</span></div></a>
  </header>
  <main class="catalog-page">



    
    <section class="catalog-panel">
      <h1>Catálogo Pop</h1>

      <p>Registra y busca artistas, canciones y álbumes.</p>

       <form class="search-form" action="${pageContext.request.contextPath}/pop" method="get">
        <label for="filtro">Buscar por artista, canción o álbum</label>
        <div class="search-row"><input id="filtro" type="search" name="filtro" value="${filtro}"><button type="submit">Buscar</button><a class="clear-link" href="${pageContext.request.contextPath}/pop">Limpiar</a></div>
      </form>

      
      <c:if test="${param.agregada == 'true'}"><p class="success-message">La canción se agregó correctamente.</p></c:if>
      <form class="catalog-form" action="${pageContext.request.contextPath}/pop" method="post">
        <h2>Añadir canción</h2>
        <div class="form-fields">
          <label>Artista <input name="artista" required></label>
          <label>Canción <input name="titulo" required></label>
          <label>Álbum <input name="album" required></label>
        </div>
        <button type="submit">Añadir canción</button>
      </form>
     


      <h2>Listado de canciones</h2>
      <div class="song-grid">
        <c:forEach var="cancion" items="${canciones}">
          <c:choose>
            <c:when test="${not empty cancion.pagina}"><a href="${pageContext.request.contextPath}/pop?cancion=${cancion.id}"><div class="song-card">
              <div class="card-image-box"><img src="${pageContext.request.contextPath}/images/${cancion.imagen}" alt="${cancion.titulo}"></div>
              <span class="card-title">${cancion.titulo}</span>
            </div></a></c:when>
            <c:otherwise><div class="song-card">
              <div class="card-image-box"><img src="${pageContext.request.contextPath}/images/${cancion.imagen}" alt="${cancion.titulo}"></div>
              <span class="card-title">${cancion.titulo}</span>
            </div></c:otherwise>
          </c:choose>
        </c:forEach>
      </div>
    </section>
  </main>
</body>
</html>
