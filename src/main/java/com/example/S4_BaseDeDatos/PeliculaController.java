package com.example.S4_BaseDeDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/peliculas")

public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;  
    
    @GetMapping
    public List<Pelicula> getAllPeliculas(){
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/{Id}")
    public Optional<Pelicula> getPeliculasById(@PathVariable Integer Id){
        return peliculaService.getPeliculasById(Id);
    }
    
}
