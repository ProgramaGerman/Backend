import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

package com.example.Prueba.controlador;


@RestController
public class controlador {

    @GetMapping("/saludo")
    public String saludo() {
        return "¡Hola, bienvenido al controlador RESTful!";
    }
}