package com.example.S6_BaseDeDatos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


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
    @NotBlank(message = "El título es obligatorio")
    @Size(min = 1, max = 100, message = "El título debe tener entre 1 y 100 caracteres")
    private String titulo;
    
    @Column(name="ano")
    @NotNull(message = "El año es obligatorio")
    @Min(value = 1900, message = "El año debe ser mayor o igual a 1900 ")
    @Max(value = 2025, message = "El año debe ser menor o igual a 2025")
    private int ano;
    
    @Column(name="director")
    @NotBlank(message = "El director es obligatorio")
    @Size(min = 1, max = 100, message = "El nombre del director debe tener entre 1 y 100 caracteres")
    private String director;
    
    @Column(name="genero")
    @NotBlank(message = "El género es obligatorio")
    @Size(min = 1, max = 50, message = "El género debe tener entre 1 y 50 caracteres")
    private String genero;
    
    @Column(name="sinopsis")
    @Size(max = 500, message = "La sinopsis no debe superar los 500 caracteres")
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
    public void SetId(int Id){
        this.id = Id;
    }
}