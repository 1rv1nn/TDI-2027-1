package com.pop_site.pop_site;

import java.util.List;
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
    private static final Map<String, Set<String>> ALBUMES_POR_ARTISTA = Map.of(
            "Michael Jackson", Set.of("Dangerous", "Triller", "Bad", "Invicible", "OffTheWall"),
            "Madonna", Set.of("Madonna", "True Blue", "LikeVirgin", "LikePrayer",
                    "Erotica", "ConfessionsFloor"));
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

    @GetMapping({"/canciones", "/canciones/nueva"})
    public String mostrarFormulario() {
        return "canciones";
    }

    @PostMapping("/canciones")
    public String agregarCancion(
            @RequestParam String artista,
            @RequestParam String titulo,
            @RequestParam String album) {

        if (!ARTISTAS.contains(artista)
                || titulo.isBlank()
                || !ALBUMES_POR_ARTISTA.get(artista).contains(album)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Los datos de la canción no son válidos");
        }

        Cancion cancion = new Cancion(artista, titulo, album);
        cancionRepository.save(cancion);

        return "redirect:/canciones/registradas";
    }

    @GetMapping("/canciones/registradas")
    public String mostrarCanciones(Model model) {
        List<Cancion> canciones = cancionRepository.findAll();

        model.addAttribute("canciones", canciones);

        return "lista-canciones";
    }
}