package com.example.S92_MICRISERVICIO_2;

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
@RequestMapping("/usuarios")
public class UsuariosRegistroController {

        @Autowired
        private UsuariosRegistroService service;

        @GetMapping
        public List<UsuariosRegistro> listar() {
                return service.listarTodos();
        }

        @PostMapping
        public UsuariosRegistro crear(@RequestBody UsuariosRegistro p) {
                return service.guardar(p);
        }

        @GetMapping("/{id}")
        public ResponseEntity<EntityModel<UsuariosRegistro>> obtener(@PathVariable Long id) {
                return service.buscarPorId(id)
                                .map(registro -> {
                                        EntityModel<UsuariosRegistro> recurso = EntityModel.of(registro);
                                        recurso.add(linkTo(methodOn(UsuariosRegistroController.class).obtener(id))
                                                        .withSelfRel());
                                        recurso.add(linkTo(methodOn(UsuariosRegistroController.class).listar())
                                                        .withRel("todos"));
                                        return ResponseEntity.ok(recurso);
                                })
                                .orElse(ResponseEntity.notFound().build());
        }

        @PutMapping("/{id}")
        public ResponseEntity<UsuariosRegistro> actualizar(@PathVariable Long id, @RequestBody UsuariosRegistro p) {
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