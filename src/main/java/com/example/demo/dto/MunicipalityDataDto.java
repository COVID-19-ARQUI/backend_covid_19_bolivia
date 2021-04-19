package com.example.demo.dto;

public class MunicipalityDataDto {
    private Integer dato;
    private String municipio;
    private String tipo;

    public MunicipalityDataDto() {
    }

    @Override
    public String toString() {
        return "MunicipalityDataDto{" +
                "dato=" + dato +
                ", municipio='" + municipio + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public Integer getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
