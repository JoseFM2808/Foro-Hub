package com.example.ForoHub.mapper;

import com.example.ForoHub.dto.UsuarioDTO;
import com.example.ForoHub.entity.Perfil;
import com.example.ForoHub.entity.Usuario;
import com.example.ForoHub.repository.PerfilRepository;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {
        Long perfilId = usuario.getPerfil() != null ? usuario.getPerfil().getId() : null;
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreoElectronico(),
                perfilId
        );
    }

    public static Usuario toEntity(UsuarioDTO usuarioDTO, PerfilRepository perfilRepository) {
        Perfil perfil = perfilRepository.findById(usuarioDTO.getPerfilId())
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el perfil con ID " + usuarioDTO.getPerfilId()));
        return new Usuario(
                usuarioDTO.getNombre(),
                usuarioDTO.getCorreoElectronico(),
                null, // Si no necesitas la contraseña en el DTO, puedes dejarlo como null
                perfil
        );
    }
}