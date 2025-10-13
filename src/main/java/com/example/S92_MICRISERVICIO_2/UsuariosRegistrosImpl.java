package com.example.S92_MICRISERVICIO_2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosRegistrosImpl implements UsuariosRegistroService {
    @Autowired
    private final UsuariosRegistroRepository repository;

    public UsuariosRegistrosImpl(UsuariosRegistroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UsuariosRegistro> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<UsuariosRegistro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public UsuariosRegistro guardar(UsuariosRegistro registro) {
        return repository.save(registro);
    }

    @Override
    public Optional<UsuariosRegistro> actualizar(Long id, UsuariosRegistro registro) {
        return repository.findById(id).map(actual -> {
            actual.setNombre(registro.getNombre());
            actual.setEmail(registro.getEmail());
            actual.setTelefono(registro.getTelefono());
            actual.setFechaRegistro(registro.getFechaRegistro());
            actual.setTipo(registro.getTipo());
            actual.setCalle(registro.getCalle());
            actual.setCiudad(registro.getCiudad());
            actual.setRegion(registro.getRegion());
            actual.setCodigo_postal(registro.getCodigo_postal());
            actual.setPais(registro.getPais());
            actual.setEs_direccion_principal(registro.getEs_direccion_principal());
            actual.setEstado(registro.getEstado());

            return repository.save(actual);
        });
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}