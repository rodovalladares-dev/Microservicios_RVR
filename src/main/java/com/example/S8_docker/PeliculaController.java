package com.example.S8_docker;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public CollectionModel<EntityModel<Pelicula>> getAllPeliculas() {
        List<EntityModel<Pelicula>> peliculas = peliculaService.getAllPeliculas().stream()
                .map(pelicula -> EntityModel.of(pelicula,
                        linkTo(methodOn(PeliculaController.class).getPeliculasById(pelicula.getId())).withSelfRel(),
                        linkTo(methodOn(PeliculaController.class).getAllPeliculas()).withRel("peliculas")))
                .collect(Collectors.toList());

        return CollectionModel.of(peliculas,
                linkTo(methodOn(PeliculaController.class).getAllPeliculas()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Pelicula> getPeliculasById(@PathVariable Integer id) {
        Pelicula pelicula = peliculaService.getPeliculasById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la película con el id: " + id));

        return EntityModel.of(pelicula,
                linkTo(methodOn(PeliculaController.class).getPeliculasById(id)).withSelfRel(),
                linkTo(methodOn(PeliculaController.class).getAllPeliculas()).withRel("peliculas"));
    }

    @PostMapping
    public ResponseEntity<EntityModel<Pelicula>> createPelicula(@Valid @RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = peliculaService.createPelicula(pelicula);

        EntityModel<Pelicula> peliculaResource = EntityModel.of(nuevaPelicula,
                linkTo(methodOn(PeliculaController.class).getPeliculasById(nuevaPelicula.getId())).withSelfRel());

        return ResponseEntity
                .created(WebMvcLinkBuilder.linkTo(methodOn(PeliculaController.class).getPeliculasById(nuevaPelicula.getId())).toUri())
                .body(peliculaResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Pelicula>> updatePelicula(@PathVariable int id, @Valid @RequestBody Pelicula pelicula) {
        Pelicula peliculaActualizada = peliculaService.updatePelicula(id, pelicula);
        EntityModel<Pelicula> peliculaResource = EntityModel.of(peliculaActualizada,
                linkTo(methodOn(PeliculaController.class).getPeliculasById(id)).withSelfRel());
        return ResponseEntity.ok(peliculaResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable int id) {
        peliculaService.deletePelicula(id);
        return ResponseEntity.noContent().build();
    }
}