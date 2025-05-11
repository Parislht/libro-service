package com.dbp.libroservice.Libro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibroResponseDTO {
    private Long idLibro;
    private String titulo;
    private int anioPublicacion;
    private boolean disponible;
    private String nombreCategoria;
    private String nombreEditorial;
    private int puntuacion;

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPúntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

}