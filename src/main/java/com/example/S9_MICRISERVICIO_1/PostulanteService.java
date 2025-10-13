package com.example.S9_MICRISERVICIO_1;

import java.util.List;
import java.util.Optional;

public interface PostulanteService {
    List<Postulante> listarTodos();

    Optional<Postulante> buscarPorId(Long id);

    Postulante guardar(Postulante postulante);

    Optional<Postulante> actualizar(Long id, Postulante postulante);

    void eliminar(Long id);
}