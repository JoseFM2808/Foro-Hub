package com.example.ForoHub.dto;

public class PerfilDTO {

    private Long id;  // El campo 'id' ya no es final
    private String nombre;  // El campo 'nombre' ya no es final

    public PerfilDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
