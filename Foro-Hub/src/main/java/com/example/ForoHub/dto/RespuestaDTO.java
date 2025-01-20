package com.example.ForoHub.dto;

import java.time.LocalDateTime;

public class RespuestaDTO {

    private Long id;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Long autorId; // Solo el ID del autor
    private Long topicoId;

    public RespuestaDTO(Long id, String mensaje, LocalDateTime fechaCreacion, Long autorId, Long topicoId) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.autorId = autorId;
        this.topicoId = topicoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Long getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(Long topicoId) {
        this.topicoId = topicoId;
    }
}
