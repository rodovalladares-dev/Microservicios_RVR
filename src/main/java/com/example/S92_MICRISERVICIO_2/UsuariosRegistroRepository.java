package com.example.S92_MICRISERVICIO_2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRegistroRepository extends JpaRepository<UsuariosRegistro, Long> {
}
