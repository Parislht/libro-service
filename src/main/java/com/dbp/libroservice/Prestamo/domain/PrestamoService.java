package com.dbp.libroservice.Prestamo.domain;

import com.dbp.libroservice.Prestamo.domain.Prestamo;
import com.dbp.libroservice.Prestamo.domain.EstadoPrestamo;
import com.dbp.libroservice.Prestamo.dto.PrestamoRequestDTO;
import com.dbp.libroservice.Prestamo.dto.PrestamoResponseDTO;
import com.dbp.libroservice.Prestamo.infrastructure.PrestamoRepository;
import com.dbp.libroservice.Libro.domain.Libro;
import com.dbp.libroservice.Libro.infrastructure.LibroRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;

    public PrestamoService(PrestamoRepository prestamoRepository, LibroRepository libroRepository) {
        this.prestamoRepository = prestamoRepository;
        this.libroRepository = libroRepository;
    }

    public PrestamoResponseDTO guardarDesdeDTO(PrestamoRequestDTO dto) {
        Libro libro = libroRepository.findById(dto.getIdLibro())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        Prestamo prestamo = new Prestamo();
        prestamo.setLibro(libro);
        prestamo.setIdUsuario(dto.getIdUsuario());
        prestamo.setFechaPrestamo(dto.getFechaPrestamo());
        prestamo.setFechaDevolucion(dto.getFechaDevolucion());
        prestamo.setEstado(dto.getEstado());

        return convertirADTO(prestamoRepository.save(prestamo));
    }

    public List<PrestamoResponseDTO> obtenerTodosComoDTO() {
        return prestamoRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public PrestamoResponseDTO actualizarEstado(Long id, String nuevoEstado) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        prestamo.setEstado(nuevoEstado);
        return convertirADTO(prestamoRepository.save(prestamo));
    }

    private PrestamoResponseDTO convertirADTO(Prestamo prestamo) {
        PrestamoResponseDTO dto = new PrestamoResponseDTO();
        dto.setIdPrestamo(prestamo.getIdPrestamo());
        dto.setTituloLibro(prestamo.getLibro().getTitulo());
        dto.setIdUsuario(prestamo.getIdUsuario());
        dto.setFechaPrestamo(prestamo.getFechaPrestamo());
        dto.setFechaDevolucion(prestamo.getFechaDevolucion());
        dto.setEstado(prestamo.getEstado());
        return dto;
    }
}