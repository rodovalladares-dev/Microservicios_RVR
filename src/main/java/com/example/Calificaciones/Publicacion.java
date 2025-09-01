package com.example.Calificaciones;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Publicacion {
    @JsonProperty("id_publicacion")
    private int idpublicacion;
    private String titulo;
    private String contenido;
    private Autor autor;
   @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("comentarios")
    private List<Comentario> comentarios;




    // gets
    public int getIdPublicacion() 
    { 
        return idpublicacion;
     }

    public String getTitulo() 
    { 
        return titulo; 
    }
    public String getContenido() 
    { 
        return contenido; 
    }

    public Autor getAutor() 
    { 
        return autor; 
    }

    public String getFechAutor() 
    { 
        return fecha; 
    }
    public List<Comentario> getComentario() 
    { 
        return comentarios; 
    }
}