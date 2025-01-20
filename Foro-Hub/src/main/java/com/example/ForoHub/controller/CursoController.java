package com.example.ForoHub.controller;

import com.example.ForoHub.dto.CursoDTO;
import com.example.ForoHub.entity.Curso;
import com.example.ForoHub.mapper.CursoMapper;
import com.example.ForoHub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDTO crearCurso(@RequestBody CursoDTO cursoDTO) {
        Curso curso = CursoMapper.toEntity(cursoDTO);
        return CursoMapper.toDTO(cursoRepository.save(curso));
    }

    @GetMapping
    public List<CursoDTO> listarCursos() {
        return cursoRepository.findAll().stream()
                .map(CursoMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtenerCursoPorId(@PathVariable Long id) {
        return cursoRepository.findById(id)
                .map(CursoMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> actualizarCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
        if (!cursoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cursoDTO.setId(id);
        Curso cursoActualizado = CursoMapper.toEntity(cursoDTO);
        return ResponseEntity.ok(CursoMapper.toDTO(cursoRepository.save(cursoActualizado)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        if (!cursoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}