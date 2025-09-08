package com.example.S4_BaseDeDatos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PELICULAS")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name= "titulo")
    private String titulo;
    @Column(name="ano")
    private int ano;
    @Column(name="director")
    private String director;
    @Column(name="genero")
    private String genero;
    @Column(name="sinopsis")
    private String sinopsis;


    /*public Pelicula(int id, String titulo, int ano, String director, String genero,String sinopsis){
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;

    }*/

    public int getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public int getAno(){
        return ano;
    }
    public String getDirector(){
        return director;
    }
    public String getGenero(){
        return genero;
    }
    public String getSinopsis(){
        return sinopsis;
    }
}
