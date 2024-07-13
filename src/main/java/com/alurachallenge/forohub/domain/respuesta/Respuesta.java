package com.alurachallenge.forohub.domain.respuesta;

import com.alurachallenge.forohub.domain.topico.Topico;
import com.alurachallenge.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private Boolean solucion;
    private LocalDateTime fecha_creacion;
    private Boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    /*@Autowired
    TopicoRepository topicoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta) {
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.fechaCreacion = new Date();
        this.solucion = datosRegistroRespuesta.solucion();
        this.topico = topicoRepository.findById(datosRegistroRespuesta.topico_id())
                .orElseThrow(() -> new ValidacionDeIntegridad.TopicoNotFoundException("Tópico no encontrado"));
        this.autor = usuarioRepository.findById(datosRegistroRespuesta.autor_id())
                .orElseThrow(() -> new ValidacionDeIntegridad.UsuarioNotFoundException("Usuario no encontrado"));
    }*/

}
