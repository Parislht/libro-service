package com.dbp.libroservice.Libro.domain;

import com.dbp.libroservice.Libro.domain.Libro;
import com.dbp.libroservice.Libro.infrastructure.LibroRepository;
import com.dbp.libroservice.Libro.dto.LibroRequestDTO;
import com.dbp.libroservice.Libro.dto.LibroResponseDTO;
import com.dbp.libroservice.Categoria.infrastructure.CategoriaRepository;
import com.dbp.libroservice.Editorial.infrastructure.EditorialRepository;
import com.dbp.libroservice.Categoria.domain.Categoria;
import com.dbp.libroservice.Editorial.domain.Editorial;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final CategoriaRepository categoriaRepository;
    private final EditorialRepository editorialRepository;

    public LibroService(LibroRepository libroRepository, CategoriaRepository categoriaRepository, EditorialRepository editorialRepository) {
        this.libroRepository = libroRepository;
        this.categoriaRepository = categoriaRepository;
        this.editorialRepository = editorialRepository;
    }

    public LibroResponseDTO guardarDesdeDTO(LibroRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Editorial editorial = editorialRepository.findById(dto.getIdEditorial())
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));

        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setAnioPublicacion(dto.getAnioPublicacion());
        libro.setDisponible(dto.isDisponible());
        libro.setCategoria(categoria);
        libro.setEditorial(editorial);
        libro.setPuntuacion(dto.getPuntuacion());

        return convertirADTO(libroRepository.save(libro));
    }

    public List<LibroResponseDTO> obtenerTodosComoDTO() {
        return libroRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public LibroResponseDTO obtenerDtoPorId(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return convertirADTO(libro);
    }

    public List<LibroResponseDTO> buscarPorTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo).stream()
                .map(this::convertirADTO)
                .toList();
    }

    public  Libro findLibroById(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        return libro;
    }

    public void save(Libro libro) {
        libroRepository.save(libro);
    }

    private LibroResponseDTO convertirADTO(Libro libro) {
        LibroResponseDTO dto = new LibroResponseDTO();
        dto.setIdLibro(libro.getIdLibro());
        dto.setTitulo(libro.getTitulo());
        dto.setAnioPublicacion(libro.getAnioPublicacion());
        dto.setDisponible(libro.isDisponible());
        dto.setNombreCategoria(libro.getCategoria().getNombreCategoria());
        dto.setNombreEditorial(libro.getEditorial().getNombreEditorial());
        dto.setPúntuacion(libro.getPuntuacion());

        return dto;
    }
}