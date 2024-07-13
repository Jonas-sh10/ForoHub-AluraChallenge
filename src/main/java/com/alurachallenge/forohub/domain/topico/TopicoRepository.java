package com.alurachallenge.forohub.domain.topico;


import com.alurachallenge.forohub.domain.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTitulo(String titulo);
    Optional<Topico> findByMensaje(String mensaje);

    Page<Topico> findByActivoTrue(Pageable paginacion);

    Page<Topico> findByCursoAndFechaCreacionBetween(Curso curso, LocalDateTime inicio, LocalDateTime fin, Pageable paginacion);

    Topico getReferenceByIdAndActivoTrue(Long id);
}
