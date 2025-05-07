package com.dbp.libroservice.Categoria.domain;

import com.dbp.libroservice.Categoria.domain.Categoria;
import com.dbp.libroservice.Categoria.dto.CategoriaRequestDTO;
import com.dbp.libroservice.Categoria.dto.CategoriaResponseDTO;
import com.dbp.libroservice.Categoria.infrastructure.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaResponseDTO guardarDesdeDTO(CategoriaRequestDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(dto.getNombreCategoria());

        return convertirADTO(categoriaRepository.save(categoria));
    }

    public List<CategoriaResponseDTO> obtenerTodosComoDTO() {
        return categoriaRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    private CategoriaResponseDTO convertirADTO(Categoria categoria) {
        CategoriaResponseDTO dto = new CategoriaResponseDTO();
        dto.setIdCategoria(categoria.getIdCategoria());
        dto.setNombreCategoria(categoria.getNombreCategoria());
        return dto;
    }
}