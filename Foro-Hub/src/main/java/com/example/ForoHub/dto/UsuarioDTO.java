package com.example.ForoHub.dto;

public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String correoElectronico;
    private Long perfilId;

    public UsuarioDTO(Long id, String nombre, String correoElectronico, Long perfilId) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.perfilId = perfilId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Long perfilId) {
        this.perfilId = perfilId;
    }
}