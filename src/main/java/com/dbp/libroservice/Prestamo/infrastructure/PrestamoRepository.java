package com.dbp.libroservice.Prestamo.infrastructure;

import com.dbp.libroservice.Prestamo.domain.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}