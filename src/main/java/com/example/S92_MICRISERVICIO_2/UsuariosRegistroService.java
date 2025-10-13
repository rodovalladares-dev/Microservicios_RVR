package com.example.S92_MICRISERVICIO_2;

import java.util.List;
import java.util.Optional;

public interface UsuariosRegistroService {
    List<UsuariosRegistro> listarTodos();

    Optional<UsuariosRegistro> buscarPorId(Long id);

    UsuariosRegistro guardar(UsuariosRegistro registro);

    Optional<UsuariosRegistro> actualizar(Long id, UsuariosRegistro registro);

    void eliminar(Long id);
}
