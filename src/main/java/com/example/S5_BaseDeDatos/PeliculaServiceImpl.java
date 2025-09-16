package com.example.S5_BaseDeDatos;

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
        if(peliculaRepository.existsById(id)){
            pelicula.SetId(id);
            return peliculaRepository.save(pelicula);
        }else{
            return null;
        }
    }
    @Override
    public void deletePelicula(int id){
        peliculaRepository.deleteById(id);
    }

    
}