package com.alurachallenge.forohub.domain.curso;

import com.alurachallenge.forohub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Boolean activo;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Topico> topico;

    /*public Curso(DatosRegistroCurso datosRegistroCurso) {
        this.nombre = datosRegistroCurso.nombre();
        this.categoria = datosRegistroCurso.categoria();
    }*/
}
