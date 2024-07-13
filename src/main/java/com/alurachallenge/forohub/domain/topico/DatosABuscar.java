package com.alurachallenge.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosABuscar(
        @NotBlank
        String nombreCurso,
        @NotBlank
        String anio
) {
}
