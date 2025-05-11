package com.dbp.libroservice.Categoria.application;

import com.dbp.libroservice.Categoria.domain.CategoriaService;
import com.dbp.libroservice.Categoria.dto.CategoriaRequestDTO;
import com.dbp.libroservice.Categoria.dto.CategoriaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> guardar(@RequestBody CategoriaRequestDTO dto) {
        return ResponseEntity.ok(categoriaService.guardarDesdeDTO(dto));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> obtenerTodas() {
        return ResponseEntity.ok(categoriaService.obtenerTodosComoDTO());
    }
}