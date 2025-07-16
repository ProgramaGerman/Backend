package com.example.Prueba.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class controlador {

    @GetMapping("/saludo")
    public String saludo() {
        // Este método maneja las solicitudes GET a la ruta /saludo
        return "¡Hola, bienvenido al controlador RESTful!";
    }
}