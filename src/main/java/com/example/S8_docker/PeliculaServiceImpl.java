package com.example.S8_docker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PeliculaServiceImpl implements PeliculaService{
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> getAllPeliculas(){
        return peliculaRepository.findAll();
    }
    @Override
    public Optional<Pelicula> getPeliculasById(Integer Id){
        return peliculaRepository.findById(Id);
    }

    //logica de negocio
    @Override
    public Pelicula createPelicula(Pelicula pelicula){
        return peliculaRepository.save(pelicula);
    }
    @Override
    public Pelicula updatePelicula (int id, Pelicula pelicula){    
        return peliculaRepository.findById(id).map(p -> {
            pelicula.SetId(id);
            return peliculaRepository.save(pelicula);
        }).orElseThrow(() -> new ResourceNotFoundException("No se encontró la película con el id: " + id));
    }
    @Override
    public void deletePelicula(int id){
        peliculaRepository.deleteById(id);
    }

    
}