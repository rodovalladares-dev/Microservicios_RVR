package com.example.S9_MICRISERVICIO_1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostulanteServiceImpl implements PostulanteService {
    @Autowired
    private final PostulanteRepository repository;

    public PostulanteServiceImpl(PostulanteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Postulante> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Postulante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Postulante guardar(Postulante postulante) {
        return repository.save(postulante);
    }

    @Override
    public Optional<Postulante> actualizar(Long id, Postulante postulante) {
        return repository.findById(id).map(actual -> {
            actual.setNombre(postulante.getNombre());
            actual.setEdad(postulante.getEdad());
            actual.setEstadoCivil(postulante.getEstadoCivil());
            actual.setProfesion(postulante.getProfesion());
            actual.setTituloUniversitario(postulante.getTituloUniversitario());
            actual.setFechaGraduacion(postulante.getFechaGraduacion());
            actual.setExperienciaLaboral(postulante.getExperienciaLaboral());
            actual.setIdioma(postulante.getIdioma());
            return repository.save(actual);
        });
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}