package com.alurachallenge.forohub.domain.topico;

import com.alurachallenge.forohub.domain.curso.CursoRepository;
import com.alurachallenge.forohub.domain.usuario.UsuarioRepository;
import com.alurachallenge.forohub.infra.error.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DatosRespuestaTopico crearTopico(DatosRegistroTopico datosRegistroTopico) {
        if (!usuarioRepository.findById(datosRegistroTopico.usuario_id()).isPresent()) {
            throw new ValidacionDeIntegridad("Usuario no encontrado");
        }

        if (!cursoRepository.findById(datosRegistroTopico.curso_id()).isPresent()) {
            throw new ValidacionDeIntegridad("Curso no encontrado");
        }

        if (topicoRepository.findByTitulo(datosRegistroTopico.titulo()).isPresent()) {
            throw new ValidacionDeIntegridad("Título de tópico ya existe");
        }

        if (topicoRepository.findByMensaje(datosRegistroTopico.mensaje()).isPresent()) {
            throw new ValidacionDeIntegridad("Mensaje del tópico ya existe");
        }

        var usuario = usuarioRepository.findById(datosRegistroTopico.usuario_id()).get();
        var curso = cursoRepository.findById(datosRegistroTopico.curso_id()).get();

        var topico = new Topico(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje(), usuario, curso);

        topicoRepository.save(topico);
        return new DatosRespuestaTopico(topico);

    }

    public Page<DatosListaTopico> getAllTopico(Pageable paginacion) {
        Page<Topico> paginacionTopico = topicoRepository.findByActivoTrue(paginacion);
        return paginacionTopico.map(DatosListaTopico::new);
    }

    public Page<DatosListaTopico> getTopicoPorCursoYAnio(String nombreCurso, String anio, Pageable paginacion) {
        System.out.println("Nombre del curso recibido: " + nombreCurso + " y " + anio);
        var cursoBuscado = cursoRepository.findByNombre(nombreCurso);

        if (cursoBuscado == null) {
            throw new ValidacionDeIntegridad("Curso no encontrado");
        }

        LocalDateTime inicioDelAnio;
        LocalDateTime finDelAnio;
        try {
            int anioEnNumero = Integer.parseInt(anio);
            inicioDelAnio = LocalDateTime.of(anioEnNumero, 1, 1, 0, 0);
            finDelAnio = LocalDateTime.of(anioEnNumero, 12, 31, 23, 59, 59);
        } catch (NumberFormatException e) {
            throw new ValidacionDeIntegridad("Formato de fecha incorrecto");
        }

        var topicos = topicoRepository.findByCursoAndFechaCreacionBetween(cursoBuscado, inicioDelAnio, finDelAnio, paginacion);

        if (topicos.isEmpty()) {
            throw new ValidacionDeIntegridad("No se encontraron tópicos para el curso y año especificado");
        }

        var datosListaTopico = topicos.getContent().stream()
                .map(DatosListaTopico::new)
                .collect(Collectors.toList());

        return new PageImpl<>(datosListaTopico, paginacion, topicos.getTotalElements());
    }

    public DatosListaTopico getTopicoPorId(Long id) {
        Topico topico = topicoRepository.getReferenceByIdAndActivoTrue(id);

        if (topico == null) {
            throw new ValidacionDeIntegridad("Tópico no encontrado para el id: " + id);
        }

        return new DatosListaTopico(topico);
    }

    public DatosListaTopico updateTopico(DatosActualizarTopico datosActualizarTopico) {
        if (!topicoRepository.findById(datosActualizarTopico.id()).isPresent()){
            throw new ValidacionDeIntegridad("Tópico no encontrado para el id: " + datosActualizarTopico.id());
        }

        if (topicoRepository.findByTitulo(datosActualizarTopico.titulo()).isPresent()){
            throw new ValidacionDeIntegridad("Este título ya se encuentra en uso por otro tópico");
        }

        if (topicoRepository.findByMensaje(datosActualizarTopico.mensaje()).isPresent()){
            throw new ValidacionDeIntegridad("Este mensaje ya se encuentra en uso por otro tópico");
        }

        Topico topico = topicoRepository.getReferenceByIdAndActivoTrue(datosActualizarTopico.id());

        topico.actualizarDatos(datosActualizarTopico);

        return new DatosListaTopico(topico);
    }

    public void deleteTopicoLogico(Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (!optionalTopico.isPresent() || !optionalTopico.get().getActivo()) {
            throw new ValidacionDeIntegridad("Tópico no encontrado o esta inactivo para el id: " + id);
        }

        Topico topico = topicoRepository.getReferenceByIdAndActivoTrue(id);
        topico.desactivarTopico();
        topicoRepository.save(topico);
    }

    public void deleteTopicoFisico(Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (!optionalTopico.isPresent()) {
            throw new ValidacionDeIntegridad("Tópico no encontrado para el id: " + id);
        }

        topicoRepository.deleteById(id);
    }
}
