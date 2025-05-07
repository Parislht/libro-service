package com.dbp.libroservice.Editorial.domain;

import com.dbp.libroservice.Libro.domain.Libro;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditorial;

    private String nombreEditorial;
    private String pais;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;

    public Long getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Long idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<com.dbp.libroservice.Libro.domain.Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<com.dbp.libroservice.Libro.domain.Libro> libros) {
        this.libros = libros;
    }



}
