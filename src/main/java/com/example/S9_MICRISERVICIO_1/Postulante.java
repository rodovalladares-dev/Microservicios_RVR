package com.example.S9_MICRISERVICIO_1;

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
@Table(name = "POSTULANTES")
public class Postulante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    @NotBlank(message = "Nombre es obligatorio")
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    private String nombre;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 18, message = "la edad minima es 18 ")
    @Max(value = 99, message = "la edad maxima es 99")
    @Column(name = "EDAD")
    private Integer edad;

    @NotBlank(message = "El estado civil es obligatorio")
    @Size(min = 1, max = 50, message = "El estado civil debe tener entre 1 y 50 caracteres")
    @Column(name = "ESTADO_CIVIL")
    private String estadoCivil;

    @NotBlank(message = "La profesión es obligatoria")
    @Size(min = 1, max = 100, message = "La profesión debe tener entre 1 y 100 caracteres")
    @Column(name = "PROFESION")
    private String profesion;

    @NotBlank(message = "El título universitario es obligatorio")
    @Size(min = 1, max = 100, message = "El título universitario debe tener entre 1 y 100 caracteres")
    @Column(name = "TITULO_UNIVERSITARIO")
    private String tituloUniversitario;

    @NotBlank(message = "La fecha de graduación es obligatoria")
    @Size(min = 1, max = 20, message = "La fecha de graduación debe tener entre 1 y 20 caracteres")
    @Column(name = "FECHA_GRADUACION")
    private String fechaGraduacion;

    @NotBlank(message = "La experiencia laboral es obligatoria")
    @Size(min = 1, max = 500, message = "La experiencia laboral debe tener entre 1 y 500 caracteres")
    @Column(name = "EXPERIENCIA_LABORAL")
    private String experienciaLaboral;

    @NotBlank(message = "El idioma es obligatorio")
    @Size(min = 1, max = 50, message = "El idioma debe tener entre 1 y 50 caracteres")
    @Column(name = "IDIOMA")
    private String idioma;

    public Postulante() {
        id = null;
        edad = null;
        estadoCivil = null;
        nombre = null;
        profesion = null;
        tituloUniversitario = null;
        fechaGraduacion = null;
        experienciaLaboral = null;
        idioma = null;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTituloUniversitario() {
        return tituloUniversitario;
    }

    public void setTituloUniversitario(String tituloUniversitario) {
        this.tituloUniversitario = tituloUniversitario;
    }

    public String getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(String fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

}