package com.example.S9_MICRISERVICIO_1;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;

@RestController
@RequestMapping("/postulantes")
public class PostulanteController {

    @Autowired
    private PostulanteService service;

    @GetMapping
    public List<Postulante> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Postulante crear(@RequestBody Postulante p) {
        return service.guardar(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Postulante>> obtener(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(postulante -> {
                    EntityModel<Postulante> recurso = EntityModel.of(postulante);
                    recurso.add(linkTo(methodOn(PostulanteController.class).obtener(id)).withSelfRel());
                    recurso.add(linkTo(methodOn(PostulanteController.class).listar()).withRel("todos"));
                    return ResponseEntity.ok(recurso);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postulante> actualizar(@PathVariable Long id, @RequestBody Postulante p) {
        return service.buscarPorId(id)
                .map(existente -> {
                    p.setId(id);
                    return ResponseEntity.ok(service.guardar(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}