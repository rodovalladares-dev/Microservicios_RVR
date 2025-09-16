package com.example.S4_BaseDeDatos;
import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    List<Pelicula> getAllPeliculas();
    Optional<Pelicula> getPeliculasById(Integer id);

    
}