package com.pop_site.pop_site;

import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class PopController {

  private final CancionRepository cancionRepository;

public PopController(CancionRepository cancionRepository) {
    this.cancionRepository = cancionRepository;
}


    private static final Set<String> ARTISTAS = Set.of("Michael Jackson", "Madonna");
    private static final Set<String> TITULOS = Set.of("Dangerous", "Into The Groove");
    private static final Set<String> ALBUMES = Set.of("Dangerous", "Holiday");

    private static final Map<String, String> CANCIONES = Map.ofEntries(
            Map.entry("like_virgin", "like_virgin.html"),
            Map.entry("remember_time", "remember_time.html"),
            Map.entry("papa_dont_preach", "papa_dont_preach.html"),
            Map.entry("one_more_chance", "one_more_chance.html"),
            Map.entry("holiday", "holiday.html"),
            Map.entry("baby_be_mine", "baby_be_mine.html"),
            Map.entry("you_rock_my_world", "you_rock_my_world.html"),
            Map.entry("everybody", "everybody.html"));

    // Era doGet
    @GetMapping("/pop")
    public String inicio(@RequestParam(required = false) String cancion) {
        if (cancion == null || cancion.isBlank()) {
            return "forward:/index.html";
        }
        String pagina = CANCIONES.get(cancion);
        if (pagina == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Canción no encontrada");
        }
        return "redirect:/html/" + pagina;
    }

    // Antes se accedía directo a canciones.jsp
    @GetMapping("/canciones")
    public String formulario() {
        return "canciones"; // templates/canciones.html
    }

    // Era doPost
    @PostMapping("/pop")
    public String agregar(@RequestParam String artista,
                          @RequestParam String titulo,
                          @RequestParam String album,
                          Model model) {

        if (!ARTISTAS.contains(artista) || !TITULOS.contains(titulo) || !ALBUMES.contains(album)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Los datos de la canción no son válidos");
        }

        Cancion guardada = cancionRepository.save(new Cancion(artista, titulo, album));

        model.addAttribute("artista", guardada.getArtista());
        model.addAttribute("titulo", guardada.getTitulo());
        model.addAttribute("album", guardada.getAlbum());


        return "cancion-agregada"; // templates/cancion-agregada.html
    }
}