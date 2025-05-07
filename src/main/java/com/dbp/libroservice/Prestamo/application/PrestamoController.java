package com.dbp.libroservice.Prestamo.application;

import com.dbp.libroservice.Prestamo.domain.PrestamoService;
import com.dbp.libroservice.Prestamo.dto.PrestamoRequestDTO;
import com.dbp.libroservice.Prestamo.dto.PrestamoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping
    public ResponseEntity<PrestamoResponseDTO> guardar(@RequestBody PrestamoRequestDTO dto) {
        return ResponseEntity.ok(prestamoService.guardarDesdeDTO(dto));
    }

    @GetMapping
    public ResponseEntity<List<PrestamoResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(prestamoService.obtenerTodosComoDTO());
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<PrestamoResponseDTO> actualizarEstado(@PathVariable Long id, @RequestParam String nuevoEstado) {
        return ResponseEntity.ok(prestamoService.actualizarEstado(id, nuevoEstado));
    }
}