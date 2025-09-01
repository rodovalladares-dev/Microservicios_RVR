package com.example.Calificaciones;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CalificacionesController {
    private List<Publicacion> publicaciones = new ArrayList<>();

    public CalificacionesController() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/Data/calificacionesok.json");
            publicaciones = mapper.readValue(inputStream, new TypeReference<List<Publicacion>>() {});
            System.err.println(publicaciones);
        } catch (Exception e) {

            System.err.println("Error al cargar publicaciones.json: " + e.getMessage() + e.hashCode());
        }
    }

    @GetMapping("/publicaciones")
    public List<Publicacion> getpublicaciones() {
        return publicaciones;
    }

    @GetMapping("/publicaciones/{id}")
    public Publicacion getCalificacionById(@PathVariable int id) {
        for (Publicacion v : publicaciones) {
            if (v.getIdPublicacion() == id) {
                return v;
            }
        }
        return null;
    }
    @GetMapping("/publicaciones/autor")
    public List<Autor> getAutor() {
        Map<Integer, Autor> AutoresUnicos = new HashMap<>();
        for (Publicacion v : publicaciones) {
            Autor c = v.getAutor();
            AutoresUnicos.putIfAbsent(c.getId(), c);
        }
        return new ArrayList<>(AutoresUnicos.values());
    }


    @GetMapping("/publicaciones/autor/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable int id) {
        return publicaciones.stream()
            .map(Publicacion::getAutor)
            .filter(c -> c.getId() == id)
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(null);

    
    }
    



    @GetMapping("/publicaciones/comentarios")
    public List<Comentario> getComentarios() {
        List<Comentario> comentarios = new ArrayList<>();
        for (Publicacion v : publicaciones) {
            comentarios.addAll(v.getComentario());
        }
        return comentarios;
    }


    @GetMapping("/publicaciones/comentarios/{id}")
    public ResponseEntity<Comentario> getComentarioById(@PathVariable int id) {
        return publicaciones.stream()
            .flatMap(v -> v.getComentario().stream())
            .filter(p -> p.getId() == id)
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(null);

    }


}