package com.ejemplo.mvc.dao;

import com.ejemplo.mvc.model.Cancion;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Locale;
import java.util.UUID;

public class CancionDAO {
    private final List<Cancion> canciones = new ArrayList<>(List.of(
            new Cancion("like_virgin", "Like a virgin", "Madonna", "Holiday", "like_virgin.jpg", "like_virgin.html"),
            new Cancion("remember_time", "Remember the time", "Michael Jackson", "Dangerous", "dangerous.jpg", "remember_time.html"),
            new Cancion("papa_dont_preach", "Papa dont preach", "Madonna", "Holiday", "true_blue.jpg", "papa_dont_preach.html"),
            new Cancion("one_more_chance", "One more chance", "Michael Jackson", "Dangerous", "numberOnes.jpg", "one_more_chance.html"),
            new Cancion("holiday", "Holiday", "Madonna", "Holiday", "madonna.jpg", "holiday.html"),
            new Cancion("baby_be_mine", "Baby be mine", "Michael Jackson", "Dangerous", "triller.jpg", "baby_be_mine.html"),
            new Cancion("you_rock_my_world", "You Rock My World", "Michael Jackson", "Dangerous", "numberOnes.jpg", "you_rock_my_world.html"),
            new Cancion("everybody", "Everybody", "Madonna", "Holiday", "madonna.jpg", "everybody.html")));

    public synchronized List<Cancion> listar(String filtro) {
        String texto = filtro == null ? "" : filtro.trim().toLowerCase(Locale.ROOT);
        return canciones.stream()
                .filter(cancion -> texto.isBlank() || coincide(cancion, texto))
                .toList();
    }

    public synchronized Optional<Cancion> buscarPorId(String id) {
        return canciones.stream().filter(cancion -> cancion.getId().equals(id)).findFirst();
    }

    public boolean esValida(Map<String, String> datos) {
        return noVacio(datos.get("artista"))
                && noVacio(datos.get("titulo"))
                && noVacio(datos.get("album"));
    }

    public synchronized Cancion agregar(String artista, String titulo, String album) {
        String imagen = artista.equalsIgnoreCase("Madonna") ? "queen_pop.jpg" : "king_pop.jpg";
        Cancion cancion = new Cancion(UUID.randomUUID().toString(), titulo, artista, album, imagen, null);
        canciones.add(cancion);
        return cancion;
    }

    private boolean coincide(Cancion cancion, String texto) {
        return cancion.getArtista().toLowerCase(Locale.ROOT).contains(texto)
                || cancion.getTitulo().toLowerCase(Locale.ROOT).contains(texto)
                || cancion.getAlbum().toLowerCase(Locale.ROOT).contains(texto);
    }

    private boolean noVacio(String valor) {
        return valor != null && !valor.isBlank();
    }
}
