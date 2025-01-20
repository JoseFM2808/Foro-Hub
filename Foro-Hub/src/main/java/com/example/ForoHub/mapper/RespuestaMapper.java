package com.example.ForoHub.mapper;

import com.example.ForoHub.dto.RespuestaDTO;
import com.example.ForoHub.entity.Respuesta;
import com.example.ForoHub.entity.Topico;
import com.example.ForoHub.entity.Usuario;
import com.example.ForoHub.repository.TopicoRepository;
import com.example.ForoHub.repository.UsuarioRepository;

public class RespuestaMapper {

    public static RespuestaDTO toDTO(Respuesta respuesta) {
        return new RespuestaDTO(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getAutor().getId(),
                respuesta.getTopico().getId()
        );
    }

    public static Respuesta toEntity(RespuestaDTO respuestaDTO, UsuarioRepository usuarioRepository, TopicoRepository topicoRepository) {
        Usuario autor = usuarioRepository.findById(respuestaDTO.getAutorId())
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el autor con ID " + respuestaDTO.getAutorId()));
        Topico topico = topicoRepository.findById(respuestaDTO.getTopicoId())
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el tópico con ID " + respuestaDTO.getTopicoId()));
        return new Respuesta(
                respuestaDTO.getMensaje(),
                topico,
                autor
        );
    }
}
