package com.dbp.libroservice.Editorial.infrastructure;

import com.dbp.libroservice.Editorial.domain.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepository extends JpaRepository<Editorial, Long> {
}