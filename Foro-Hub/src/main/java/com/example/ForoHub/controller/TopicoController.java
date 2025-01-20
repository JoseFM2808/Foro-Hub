package com.example.ForoHub.controller;

import com.example.ForoHub.dto.TopicoDTO;
import com.example.ForoHub.mapper.TopicoMapper;
import com.example.ForoHub.repository.CursoRepository;
import com.example.ForoHub.repository.TopicoRepository;
import com.example.ForoHub.entity.Topico;
import com.example.ForoHub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    @Autowired
    public TopicoController(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TopicoDTO crearTopico(@RequestBody @Valid TopicoDTO topicoDTO) {
        Topico topico = TopicoMapper.toEntity(topicoDTO, usuarioRepository, cursoRepository);
        return TopicoMapper.toDTO(topicoRepository.save(topico));
    }

    @GetMapping("/all-topics")
    public List<TopicoDTO> listarTodosLosTopicos() {
        return topicoRepository.findAll().stream()
                .map(TopicoMapper::toDTO)
                .toList();
    }

    @GetMapping
    public Page<TopicoDTO> top10Topicos(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "fechaCreacion") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        return topicoRepository.findAll(pageable).map(TopicoMapper::toDTO);
    }

    @GetMapping("/topicos-por-status")
    public ResponseEntity<List<TopicoDTO>> obtenerTopicosPorStatus(@RequestParam String status) {
        List<Topico> topicos = topicoRepository.findByStatus(status);
        if (topicos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontraron tópicos con el estado solicitado");
        }
        return ResponseEntity.ok(topicos.stream().map(TopicoMapper::toDTO).toList());
    }
}
