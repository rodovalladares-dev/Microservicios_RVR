package com.example.S6_BaseDeDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;




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
        try {
            return peliculaService.getPeliculasById(Id); 
        } catch (Exception e) {
            return Optional.empty();
        }   
    }
    @PostMapping
    public Pelicula createPelicula(@Valid @RequestBody Pelicula pelicula){
        return peliculaService.createPelicula(pelicula);
    }
    @PutMapping("/{id}")
    public Pelicula updatePelicula(@PathVariable int id,@Valid @RequestBody Pelicula pelicula){
        return peliculaService.updatePelicula(id, pelicula);
    }
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable int id){
        peliculaService.deletePelicula(id);
    }

    
}