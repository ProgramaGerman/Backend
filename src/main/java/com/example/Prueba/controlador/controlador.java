package com.example.Prueba.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prueba.modelos.Persona;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class controlador {

    // Este controlador maneja las solicitudes RESTful
    // y proporciona respuestas simples para las rutas definidas.

    Persona persona = new Persona();


    @GetMapping("/saludo")
    public String saludo() {
        // Este método maneja las solicitudes GET a la ruta /saludo
        return "¡Hola, bienvenido al controlador RESTful!";
    }

    @PostMapping("/saludo/{nombre}")
    public String saludoConNombre(@PathVariable String nombre) {
        //Se asigna de forma directa el id
        persona.setId(1L); // Asignación directa del ID
        // Este método maneja las solicitudes GET a la ruta /saludo/{nombre}
        persona.setNombre(nombre);
        return "El Nombre " + persona.getNombre() + " ha sido recibido correctamente."
                + " Su ID es " + persona.getId() + ".";
    }

     @GetMapping("/apellido/{apellido}")
    public String apellido(@PathVariable String apellido) {
        persona.setApellido(apellido);
        return "El Apellido " + persona.getApellido() + " de " + persona.getNombre() + " ha sido recibido correctamente.";
    }

    @GetMapping("/edad/{edad}")
    public String edad(@PathVariable int edad) {
        persona.setEdad(edad);
        return "La Edad " + persona.getEdad() + " de " + persona.getNombre() + " ha sido recibida correctamente.";
    }

    @GetMapping("/persona")
    public Persona obtenerPersona() {
        return persona;
    }

   
    @GetMapping("/despedida")
    public String despedida() {
        return "¡Hasta luego! Gracias por visitar el controlador RESTful.";
    }
}