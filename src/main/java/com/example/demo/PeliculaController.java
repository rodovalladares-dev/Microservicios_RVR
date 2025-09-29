package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;


@RestController
public class PeliculaController {
    private List<Pelicula> Peliculas = new ArrayList<>();
  
    public PeliculaController(){
        // Inicializa la lista de estudiantes con algunos datos
        Peliculas.add(new Pelicula(1,"El laberinto del fauno",2006,"Guillermo del Toro","Fantasía","Una niña descubre un mundo mágico en medio de la posguerra española."));
        Peliculas.add(new Pelicula(2,"La vida es bella",1997,"Roberto Benigni","Drama","Un padre usa el humor para proteger a su hijo de los horrores del Holocausto."));
        Peliculas.add(new Pelicula(3,"Inception",2010,"Christopher Nolan","Ciencia ficción","Un ladrón especializado en robar secretos del subconsciente debe realizar una misión imposible."));
        Peliculas.add(new Pelicula(4,"Parasite",2019,"Bong Joon-ho","Thriller","Una familia pobre se infiltra en la vida de una familia rica con consecuencias inesperadas."));
        Peliculas.add(new Pelicula(5,"Amélie",2001,"Jean-Pierre Jeunet","Comedia romántica","Una joven parisina decide cambiar la vida de quienes la rodean con pequeños actos de bondad."));
        Peliculas.add(new Pelicula(6,"El Padrino",1972,"Francis Ford Coppola","Crimen","La historia de una poderosa familia mafiosa en Nueva York."));
        Peliculas.add(new Pelicula(7,"Forrest Gump",1994,"Robert Zemeckis","Drama","Un hombre con bajo coeficiente intelectual vive momentos clave de la historia estadounidense."));
        Peliculas.add(new Pelicula(8,"Interstellar",2014,"Christopher Nolan","Ciencia ficción","Un grupo de astronautas viaja a través de un agujero de gusano en busca de un nuevo hogar para la humanidad."));
        Peliculas.add(new Pelicula(9,"La La Land",2016,"Damien Chazelle","Musical","Una aspirante a actriz y un músico luchan por sus sueños en Los Ángeles."));
        Peliculas.add(new Pelicula(10 ,"Titanic",1997,"James Cameron","Romance","Una historia de amor prohibido a bordo del famoso barco condenado."));
    }


    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas(){
        return Peliculas;
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula getPeliculaById(@PathVariable int id) {
        for (Pelicula vpelicula : Peliculas) {
            if(vpelicula.getId() == id){
                return vpelicula;
            }
        }
        return null;
    }


    public Pelicula createPelicula(Pelicula pelicula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPelicula'");
    }


    public List<Pelicula> getAllPeliculas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPeliculas'");
    }
    
}
