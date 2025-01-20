package com.example.ForoHub.mapper;

import com.example.ForoHub.dto.PerfilDTO;
import com.example.ForoHub.entity.Perfil;

public class PerfilMapper {

    public static PerfilDTO toDTO(Perfil perfil) {
        return new PerfilDTO(
                perfil.getId(),
                perfil.getNombre()
        );
    }

    public static Perfil toEntity(PerfilDTO perfilDTO) {
        return new Perfil(
                perfilDTO.getId(),
                perfilDTO.getNombre()
        );
    }
}
