package com.dbp.libroservice.Editorial.domain;

import com.dbp.libroservice.Editorial.domain.Editorial;
import com.dbp.libroservice.Editorial.dto.EditorialRequestDTO;
import com.dbp.libroservice.Editorial.dto.EditorialResponseDTO;
import com.dbp.libroservice.Editorial.infrastructure.EditorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialService {

    private final EditorialRepository editorialRepository;

    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public EditorialResponseDTO guardarDesdeDTO(EditorialRequestDTO dto) {
        Editorial editorial = new Editorial();
        editorial.setNombreEditorial(dto.getNombreEditorial());
        editorial.setPais(dto.getPais());

        return convertirADTO(editorialRepository.save(editorial));
    }

    public List<EditorialResponseDTO> obtenerTodosComoDTO() {
        return editorialRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    private EditorialResponseDTO convertirADTO(Editorial editorial) {
        EditorialResponseDTO dto = new EditorialResponseDTO();
        dto.setIdEditorial(editorial.getIdEditorial());
        dto.setNombreEditorial(editorial.getNombreEditorial());
        dto.setPais(editorial.getPais());
        return dto;
    }
}