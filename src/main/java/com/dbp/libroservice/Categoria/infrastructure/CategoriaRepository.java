package com.dbp.libroservice.Categoria.infrastructure;

import com.dbp.libroservice.Categoria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}