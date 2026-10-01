package com.pop_site.pop_site;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String artista;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String album;

    protected Cancion() { } // requerido por JPA

    public Cancion(String artista, String titulo, String album) {
        this.artista = artista;
        this.titulo = titulo;
        this.album = album;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }
}