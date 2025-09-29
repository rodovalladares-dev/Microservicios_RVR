package com.example.S7_JUNIT;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaRepositoryTest {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Test
    public void testGuardarYBuscarPelicula() {
        // Arrange
        Pelicula pelicula = new Pelicula(1, "Nacho Libre", 2006, "Jared Hess", "Comedy", "A man fights as a luchador to save an orphanage.");
        pelicula.SetId(5);
        pelicula.setTitulo("Nacho Libre");
        pelicula.setAno(2006);
        pelicula.setDirector("Jared Hess");
        pelicula.setGenero("Comedy");
        pelicula.setSinopsis("A man fights as a luchador to ROdolfo save an orphanage.");

        // El ID se deja en 0 o null para que JPA lo genere automáticamente.

        // Act
        Pelicula guardada = peliculaRepository.save(pelicula);

        // Assert
        assertNotNull(guardada.getId());
        Optional<Pelicula> encontrada = peliculaRepository.findById(guardada.getId());
        assertThat(encontrada.isPresent()).isTrue();
        assertThat(encontrada.get().getTitulo()).isEqualTo("Nacho Libre");
        assertThat(encontrada.get().getAno()).isEqualTo(2006);
        assertThat(encontrada.get().getDirector()).isEqualTo("Jared Hess");
        assertThat(encontrada.get().getGenero()).isEqualTo("Comedy");
        assertThat(encontrada.get().getSinopsis()).isEqualTo("A man fights as a luchador to save an orphanage.");
    
    }
}