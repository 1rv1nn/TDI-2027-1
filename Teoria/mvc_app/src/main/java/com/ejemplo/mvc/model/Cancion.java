package com.ejemplo.mvc.model;

public class Cancion {
    private final String id;
    private final String titulo;
    private final String artista;
    private final String album;
    private final String imagen;
    private final String pagina;

    public Cancion(String id, String titulo, String artista, String album, String imagen, String pagina) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.imagen = imagen;
        this.pagina = pagina;
    }

    public Cancion(String id, String titulo, String artista, String album) {
        this(id, titulo, artista, album, null, null);
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public String getAlbum() { return album; }
    public String getImagen() { return imagen; }
    public String getPagina() { return pagina; }
}
