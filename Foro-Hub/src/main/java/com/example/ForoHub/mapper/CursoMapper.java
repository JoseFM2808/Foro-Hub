package com.example.ForoHub.mapper;

import com.example.ForoHub.dto.CursoDTO;
import com.example.ForoHub.entity.Curso;

public class CursoMapper {

    public static CursoDTO toDTO(Curso curso) {
        return new CursoDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria()
        );
    }

    public static Curso toEntity(CursoDTO cursoDTO) {
        return new Curso(
                cursoDTO.getId(),
                cursoDTO.getNombre(),
                cursoDTO.getCategoria()
        );
    }
}
