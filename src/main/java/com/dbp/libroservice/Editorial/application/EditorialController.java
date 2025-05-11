package com.dbp.libroservice.Editorial.application;

import com.dbp.libroservice.Editorial.domain.EditorialService;
import com.dbp.libroservice.Editorial.dto.EditorialRequestDTO;
import com.dbp.libroservice.Editorial.dto.EditorialResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {

    private final EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @PostMapping
    public ResponseEntity<EditorialResponseDTO> guardar(@RequestBody EditorialRequestDTO dto) {
        return ResponseEntity.ok(editorialService.guardarDesdeDTO(dto));
    }

    @GetMapping
    public ResponseEntity<List<EditorialResponseDTO>> obtenerTodas() {
        return ResponseEntity.ok(editorialService.obtenerTodosComoDTO());
    }
}