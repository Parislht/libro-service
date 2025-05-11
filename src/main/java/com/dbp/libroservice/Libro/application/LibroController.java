package com.dbp.libroservice.Libro.application;

import com.dbp.libroservice.Libro.domain.LibroService;
import com.dbp.libroservice.Libro.domain.Libro;
import com.dbp.libroservice.Libro.dto.LibroRequestDTO;
import com.dbp.libroservice.Libro.dto.LibroResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<LibroResponseDTO> guardar(@RequestBody LibroRequestDTO dto) {
        return ResponseEntity.ok(libroService.guardarDesdeDTO(dto));
    }

    @GetMapping
    public ResponseEntity<List<LibroResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(libroService.obtenerTodosComoDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.obtenerDtoPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<LibroResponseDTO>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(libroService.buscarPorTitulo(titulo));
    }

    @PutMapping("/{id_libro}")
    public ResponseEntity<Libro> actualizarPuntuacion(@PathVariable("id_libro") Long idLibro,
                                                      @RequestBody Map<String, Object> request) {
        int nuevaPuntuacion = (int) request.get("puntuacion");

        Libro libro = libroService.findLibroById(idLibro);

        if (libro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        libro.setPuntuacion((libro.getPuntuacion() + nuevaPuntuacion) / 2);

        // Guardamos la actualización
        libroService.save(libro);

        return new ResponseEntity<>(libro, HttpStatus.OK);
    }
}