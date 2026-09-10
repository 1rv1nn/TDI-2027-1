package com.example.mi_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/hola")
    public String saludar(@RequestParam(value = "nombre", defaultValue = "Mundo") String nombre) {
        return "¡Hola, " + nombre + "! Bienvenido a Spring Boot.";
    }
}