package com.example.ForoHub.mapper;

import com.example.ForoHub.dto.TopicoDTO;
import com.example.ForoHub.entity.Curso;
import com.example.ForoHub.entity.Topico;
import com.example.ForoHub.entity.Usuario;
import com.example.ForoHub.repository.CursoRepository;
import com.example.ForoHub.repository.UsuarioRepository;

public class TopicoMapper {

    // Convierte un Topico en TopicoDTO
    public static TopicoDTO toDTO(Topico topico) {
        return new TopicoDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getStatus(),
                UsuarioMapper.toDTO(topico.getAutor()),
                CursoMapper.toDTO(topico.getCurso()),
                topico.getFechaCreacion()
        );
    }

    // Convierte TopicoDTO a Topico (usando los repositorios para obtener datos relacionados)
    public static Topico toEntity(TopicoDTO topicoDTO, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        Usuario autor = usuarioRepository.findById(topicoDTO.getAutor().getId())
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el autor con ID " + topicoDTO.getAutor().getId()));
        Curso curso = cursoRepository.findById(topicoDTO.getCurso().getId())
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el curso con ID " + topicoDTO.getCurso().getId()));

        return new Topico(
                topicoDTO.getId(),
                topicoDTO.getTitulo(),
                topicoDTO.getMensaje(),
                topicoDTO.getStatus(),
                autor,
                curso,
                topicoDTO.getFechaCreacion()
        );
    }
}
