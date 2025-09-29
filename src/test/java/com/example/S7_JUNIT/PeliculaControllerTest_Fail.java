package com.example.S7_JUNIT;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PeliculaController.class)
public class PeliculaControllerTest_Fail {

    @Autowired
    private MockMvc mockMvc;



    @MockBean
    private PeliculaService peliculaServiceMock;





    @Test
    @DisplayName("GET /peliculas/{id} - Debe retornar película por ID exitosamente")
    public void testGetPeliculaById_Exitoso() throws Exception {
        System.out.println("=== INICIANDO PRUEBA: Obtener película por ID ===");
        Pelicula pelicula = new Pelicula(1, "Inception", 2010, "Christopher Nolan", "Sci-Fi", "A mind-bending thriller");
        // Arrange

        when(peliculaServiceMock.getPeliculasById(1)).thenReturn(Optional.of(pelicula));
        System.out.println("Mock configurado: servicio retornará película con ID 1");

        // Act & Assert
        mockMvc.perform(get("/peliculas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))   // ID incorrecto para forzar fallo
                .andExpect(jsonPath("$.titulo").value("Inception"))
                .andExpect(jsonPath("$.ano").value(2010))
                .andExpect(jsonPath("$.director").value("Christopher Nolan"))
                .andExpect(jsonPath("$.genero").value("Sci-Fi"))
                .andExpect(jsonPath("$.sinopsis").value("A mind-bending thriller"));
    
        // ASSERT: Verificar que el servicio fue llamado
        verify(peliculaServiceMock).getPeliculasById(1);

    }


    
   
}