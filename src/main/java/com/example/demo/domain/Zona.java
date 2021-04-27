package com.example.demo.domain;

public class Zona {

    private Integer idZona;
    private Integer idDepartmento;
    private Integer idMunicipio;

    public Zona() {
    }

    public Zona(Integer idZona, Integer idDepartmento, Integer idMunicipio) {
        this.idZona = idZona;
        this.idDepartmento = idDepartmento;
        this.idMunicipio = idMunicipio;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "idZona=" + idZona +
                ", idDepartmento=" + idDepartmento +
                ", idMunicipio=" + idMunicipio +
                '}';
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public Integer getIdDepartmento() {
        return idDepartmento;
    }

    public void setIdDepartmento(Integer idDepartmento) {
        this.idDepartmento = idDepartmento;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
}
