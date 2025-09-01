package com.example.Calificaciones;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comentario {
    @JsonProperty("id_comentario")
    private int id_comentario;
     @JsonProperty("usuario")
    private String usuario;
     @JsonProperty("texto")
    private String texto;
     @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("calificacion")
    private int calificacion;


    // gets
    public int getId() 
    { 
        return id_comentario; 
    }

    public String getUsuarioC() 
    { 
        return usuario; 
    }
    public String getTextoC() 
    { 
        return texto; 
    }
    public String getFechaC() 
    { 
        return fecha; 
    }
    public int getCalificacionC() 
    { 
        return calificacion; 
    }


}