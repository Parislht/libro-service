package com.dbp.libroservice.Libro.infrastructure;

import com.dbp.libroservice.Libro.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByTitulo(String titulo);

}