package com.example.ForoHub.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import com.example.ForoHub.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);

    Optional<Topico> findByTituloAndMensajeAndIdNot(String titulo, String mensaje, Long id);

    List<Topico> findByCursoNombreAndFechaCreacionBetween(String cursoNombre, LocalDateTime fechaCreacionStart, LocalDateTime fechaCreacionEnd);

    // Método para obtener tópicos por su estado
    List<Topico> findByStatus(String status);

    // Método adicional para obtener tópicos abiertos por curso
    List<Topico> findByCursoNombreAndStatus(String cursoNombre, String status);
}
