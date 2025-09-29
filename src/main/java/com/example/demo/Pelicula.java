package com.example.demo;

public class Pelicula {
    private int id;
    private String titulo;
    private int ano;
    private String director;
    private String genero;
    private String sinopsis;


    public Pelicula(int id, String titulo, int ano, String director, String genero,String sinopsis){
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;

    }

    public Pelicula() {
        //TODO Auto-generated constructor stub
    }

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

    public void setId(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public void setTitulo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTitulo'");
    }

    public void setGenero(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setGenero'");
    }

    public Object getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    public void SetId(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SetId'");
    }

    public void SetTitulo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SetTitulo'");
    }

    public void SetDirector(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SetDirector'");
    }

    public void SetAno(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SetAno'");
    }

    public void SetGenero(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SetGenero'");
    }

    public void SetSinopsis(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SetSinopsis'");
    }
}
