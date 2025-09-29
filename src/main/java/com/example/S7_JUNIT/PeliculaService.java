package com.example.S7_JUNIT;
import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    List<Pelicula> getAllPeliculas();
    Optional<Pelicula> getPeliculasById(Integer id);

    // Otros métodos como crear, actualizar, eliminar, etc.
    Pelicula createPelicula(Pelicula pelicula);
    void deletePelicula(int id);
    Pelicula updatePelicula(int id, Pelicula pelicula);

}