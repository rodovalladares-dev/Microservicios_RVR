package com.example.S7_JUNIT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PeliculaServiceImplTest {

    @Mock
    private PeliculaRepository peliculaRepository;

    @InjectMocks
    private PeliculaServiceImpl peliculaService;

    private Pelicula pelicula1;
    private Pelicula pelicula2;

    @BeforeEach
    void setUp() {
        // Initialize test data
        pelicula1 = new Pelicula(1, "Inception", 2010, "Christopher Nolan", "Sci-Fi", "A thief who steals corporate secrets through the use of dream-sharing technology.");
        pelicula2 = new Pelicula(2, "The Dark Knight", 2008, "Christopher Nolan", "Action", "When the menace known as the Joker emerges from his mysterious past.");
    }

    @Test
    void testGetAllPeliculas() {
        // Arrange
        when(peliculaRepository.findAll()).thenReturn(Arrays.asList(pelicula1, pelicula2));

        // Act
        List<Pelicula> peliculas = peliculaService.getAllPeliculas();

        // Assert
        assertNotNull(peliculas);
        assertEquals(2, peliculas.size());
        verify(peliculaRepository, times(1)).findAll();
    }

    @Test
    void testGetPeliculasById_whenPeliculaExists() {
        // Arrange
        when(peliculaRepository.findById(1)).thenReturn(Optional.of(pelicula1));

        // Act
        Optional<Pelicula> foundPelicula = peliculaService.getPeliculasById(1);

        // Assert
        assertTrue(foundPelicula.isPresent());
        assertEquals(pelicula1.getTitulo(), foundPelicula.get().getTitulo());
        verify(peliculaRepository, times(1)).findById(1);
    }

    @Test
    void testGetPeliculasById_whenPeliculaDoesNotExist() {
        // Arrange
        when(peliculaRepository.findById(99)).thenReturn(Optional.empty());

        // Act
        Optional<Pelicula> foundPelicula = peliculaService.getPeliculasById(99);

        // Assert
        assertFalse(foundPelicula.isPresent());
        verify(peliculaRepository, times(1)).findById(99);
    }

    @Test
    void testCreatePelicula() {
        // Arrange
        when(peliculaRepository.save(any(Pelicula.class))).thenReturn(pelicula1);

        // Act
        Pelicula createdPelicula = peliculaService.createPelicula(pelicula1);

        // Assert
        assertNotNull(createdPelicula);
        assertEquals(pelicula1.getTitulo(), createdPelicula.getTitulo());
        verify(peliculaRepository, times(1)).save(pelicula1);
    }

    @Test
    void testUpdatePelicula_whenPeliculaExists() {
        // Arrange
        Pelicula peliculaDetailsToUpdate = new Pelicula(0, "Inception Updated", 2011, "Nolan", "Sci-Fi", "Updated Synopsis");
        when(peliculaRepository.existsById(1)).thenReturn(true);
        when(peliculaRepository.save(any(Pelicula.class))).thenAnswer(invocation -> {
            Pelicula p = invocation.getArgument(0);
            assertEquals(1, p.getId()); // Check that the ID was set correctly
            return p;
        });

        // Act
        Pelicula updatedPelicula = peliculaService.updatePelicula(1, peliculaDetailsToUpdate);

        // Assert
        assertNotNull(updatedPelicula);
        assertEquals(1, updatedPelicula.getId());
        assertEquals("Inception Updated", updatedPelicula.getTitulo());
        verify(peliculaRepository, times(1)).existsById(1);
        verify(peliculaRepository, times(1)).save(any(Pelicula.class));
    }

    @Test
    void testUpdatePelicula_whenPeliculaDoesNotExist() {
        // Arrange
        Pelicula peliculaDetailsToUpdate = new Pelicula(0, "Does not exist", 2000, "N/A", "N/A", "N/A");
        when(peliculaRepository.existsById(99)).thenReturn(false);

        // Act
        Pelicula updatedPelicula = peliculaService.updatePelicula(99, peliculaDetailsToUpdate);

        // Assert
        assertNull(updatedPelicula);
        verify(peliculaRepository, times(1)).existsById(99);
        verify(peliculaRepository, never()).save(any(Pelicula.class));
    }

    @Test
    void testDeletePelicula() {
        // Act
        peliculaService.deletePelicula(1);

        // Assert
        verify(peliculaRepository, times(1)).deleteById(1);
    }
}