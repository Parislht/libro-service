package com.dbp.libroservice.Editorial.dto;

import lombok.Getter;
import lombok.Setter;


public class EditorialRequestDTO {
    private String nombreEditorial;
    private String pais;

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



}