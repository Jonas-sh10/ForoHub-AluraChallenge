package com.alurachallenge.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        Long topico_id,
        @NotNull
        Long autor_id,
        boolean solucion
) {
}
