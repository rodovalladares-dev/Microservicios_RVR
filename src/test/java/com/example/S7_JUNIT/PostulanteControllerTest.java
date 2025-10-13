package com.example.S7_JUNIT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.S9_MICRISERVICIO_1.Postulante;
import com.example.S9_MICRISERVICIO_1.PostulanteController;
import com.example.S9_MICRISERVICIO_1.PostulanteService;

import org.springframework.hateoas.EntityModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PostulanteControllerTest {

    @InjectMocks
    private PostulanteController controller;

    @Mock
    private PostulanteService service;

    private Postulante postulante;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        postulante = new Postulante();
        postulante.setId(1L);
        postulante.setNombre("Test User");
    }

    @Test
    void listar() {
        List<Postulante> postulantes = new ArrayList<>();
        postulantes.add(postulante);
        when(service.listarTodos()).thenReturn(postulantes);

        List<Postulante> result = controller.listar();
        assertEquals(1, result.size());
        assertEquals("Test User", result.get(0).getNombre());
    }

    @Test
    void crear() {
        when(service.guardar(postulante)).thenReturn(postulante);

        Postulante result = controller.crear(postulante);
        assertNotNull(result);
        assertEquals("Test User", result.getNombre());
    }

    @Test
    void obtener_existingId_returnsOk() {
        when(service.buscarPorId(1L)).thenReturn(Optional.of(postulante));

        ResponseEntity<EntityModel<Postulante>> response = controller.obtener(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Test User", response.getBody().getContent().getNombre());
    }

    @Test
    void obtener_nonExistingId_returnsNotFound() {
        when(service.buscarPorId(1L)).thenReturn(Optional.empty());

        ResponseEntity<EntityModel<Postulante>> response = controller.obtener(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void actualizar_existingId_returnsOk() {
        when(service.buscarPorId(1L)).thenReturn(Optional.of(postulante));
        when(service.guardar(postulante)).thenReturn(postulante);

        ResponseEntity<Postulante> response = controller.actualizar(1L, postulante);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Test User", response.getBody().getNombre());
    }

    @Test
    void actualizar_nonExistingId_returnsNotFound() {
        when(service.buscarPorId(1L)).thenReturn(Optional.empty());

        ResponseEntity<Postulante> response = controller.actualizar(1L, postulante);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void eliminar_existingId_returnsNoContent() {
        ResponseEntity<Void> response = controller.eliminar(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(service, times(1)).eliminar(1L);
    }
}