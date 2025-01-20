package com.example.ForoHub.controller;

import com.example.ForoHub.dto.PerfilDTO;
import com.example.ForoHub.entity.Perfil;
import com.example.ForoHub.mapper.PerfilMapper;
import com.example.ForoHub.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    private final PerfilRepository perfilRepository;

    @Autowired
    public PerfilController(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PerfilDTO crearPerfil(@RequestBody PerfilDTO perfilDTO) {
        Perfil perfil = PerfilMapper.toEntity(perfilDTO);
        return PerfilMapper.toDTO(perfilRepository.save(perfil));
    }

    @GetMapping
    public List<PerfilDTO> listarPerfiles() {
        return perfilRepository.findAll().stream()
                .map(PerfilMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> obtenerPerfilPorId(@PathVariable Long id) {
        return perfilRepository.findById(id)
                .map(PerfilMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> actualizarPerfil(@PathVariable Long id, @RequestBody PerfilDTO perfilDTO) {
        if (!perfilRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        perfilDTO.setId(id);
        Perfil perfilActualizado = PerfilMapper.toEntity(perfilDTO);
        return ResponseEntity.ok(PerfilMapper.toDTO(perfilRepository.save(perfilActualizado)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPerfil(@PathVariable Long id) {
        if (!perfilRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        perfilRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
