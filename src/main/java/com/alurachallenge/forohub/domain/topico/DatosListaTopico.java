package com.alurachallenge.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListaTopico(
        String titulo,
        String mensaje,
        LocalDateTime fecha_creacion,
        Status status,
        Long usuario,
        Long curso
) {
    public DatosListaTopico(Topico topico){
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getUsuario().getId(),
                topico.getCurso().getId()
        );
    }
}
