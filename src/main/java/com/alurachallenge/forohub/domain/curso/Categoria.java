package com.alurachallenge.forohub.domain.curso;

public enum Categoria {
    PROGRAMMING("Programación"),
    WEB_DEVELOPMENT("Desarrollo Web"),
    DATA_SCIENCE("Ciencia de Datos"),
    SECURITY("Seguridad"),
    MOBILE_DEVELOPMENT("Desarrollo de Aplicaciones Móviles");

    private final String displayName;

    Categoria(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
