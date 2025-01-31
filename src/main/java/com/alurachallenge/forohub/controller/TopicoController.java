package com.alurachallenge.forohub.controller;

import com.alurachallenge.forohub.domain.topico.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        DatosRespuestaTopico response = topicoService.crearTopico(datosRegistroTopico);
        URI url =uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(url).body(response);
    }

    @GetMapping
    @Transactional
    @Operation(summary = "Listar tópicos",
            parameters = {
                    @Parameter(name = "size", hidden = true)
            })
    public ResponseEntity<Page<DatosListaTopico>> listarTopicos(@Parameter(hidden = true) @PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion) {
        Page<DatosListaTopico> response = topicoService.getAllTopico(paginacion);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    @Transactional
    public ResponseEntity<Page<DatosListaTopico>> listarTopicoPorCursoYAnio(
            @RequestParam String nombreCurso,
            @RequestParam String anio,
            @PageableDefault(size = 5) Pageable paginacion) {
        Page<DatosListaTopico> response = topicoService.getTopicoPorCursoYAnio(nombreCurso, anio, paginacion);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosListaTopico> listarTopicoPorId(@PathVariable Long id) {
        DatosListaTopico response = topicoService.getTopicoPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosListaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        DatosListaTopico response = topicoService.updateTopico(datosActualizarTopico);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopicoLogico(@PathVariable Long id) {
        topicoService.deleteTopicoLogico(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/fisico/{id}")
    @Transactional
    public ResponseEntity eliminarTopicoFisico(@PathVariable Long id) {
        topicoService.deleteTopicoFisico(id);
        return ResponseEntity.noContent().build();
    }

}
