package com.example.ForoHub.controller;

import com.example.ForoHub.dto.RespuestaDTO;
import com.example.ForoHub.mapper.RespuestaMapper;
import com.example.ForoHub.repository.RespuestaRepository;
import com.example.ForoHub.repository.TopicoRepository;
import com.example.ForoHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespuestaDTO crearRespuesta(@RequestBody RespuestaDTO respuestaDTO) {
        return RespuestaMapper.toDTO(respuestaRepository.save(RespuestaMapper.toEntity(respuestaDTO, usuarioRepository, topicoRepository)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaDTO> obtenerRespuestaPorId(@PathVariable Long id) {
        return respuestaRepository.findById(id)
                .map(RespuestaMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaDTO> actualizarRespuesta(@PathVariable Long id, @RequestBody RespuestaDTO respuestaDTO) {
        if (!respuestaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        respuestaDTO.setId(id);
        return ResponseEntity.ok(RespuestaMapper.toDTO(respuestaRepository.save(RespuestaMapper.toEntity(respuestaDTO, usuarioRepository, topicoRepository))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable Long id) {
        if (!respuestaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        respuestaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
