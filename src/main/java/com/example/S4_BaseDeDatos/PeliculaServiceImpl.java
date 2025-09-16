package com.example.S4_BaseDeDatos;

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
    
}