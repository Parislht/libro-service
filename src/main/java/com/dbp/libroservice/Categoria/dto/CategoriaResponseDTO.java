package com.dbp.libroservice.Categoria.dto;

import lombok.Getter;
import lombok.Setter;


public class CategoriaResponseDTO {
    private Long idCategoria;
    private String nombreCategoria;

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
