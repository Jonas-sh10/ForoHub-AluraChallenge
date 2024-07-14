package com.alurachallenge.forohub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @Email
        String email,
        @NotBlank
        String password
) {
}
