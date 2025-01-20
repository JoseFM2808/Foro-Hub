package com.example.ForoHub.dto;

import java.time.LocalDateTime;

public class TopicoDTO {

    private final Long id;
    private final String titulo;
    private final String mensaje;
    private final String status;
    private final UsuarioDTO autor;
    private final CursoDTO curso;
    private final LocalDateTime fechaCreacion;

    // Constructor con todos los campos
    public TopicoDTO(Long id, String titulo, String mensaje, String status, UsuarioDTO autor, CursoDTO curso, LocalDateTime fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getMensaje() { return mensaje; }
    public String getStatus() { return status; }
    public UsuarioDTO getAutor() { return autor; }
    public CursoDTO getCurso() { return curso; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}
