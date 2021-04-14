package com.example.demo.dto;

import com.example.demo.domain.Zona;

public class ZonaDto {
    private Integer idZona;
    private String Departamento;
    private String Ciudad;
    private String Zona;

    public ZonaDto() {
    }

    public ZonaDto(Integer idZona, String departamento, String ciudad, String zona) {
        this.idZona = idZona;
        Departamento = departamento;
        Ciudad = ciudad;
        Zona = zona;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        Departamento = departamento;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getZona() {
        return Zona;
    }

    public void setZona(String zona) {
        Zona = zona;
    }

    @Override
    public String toString() {
        return "ZonaDto{" +
                "idZona=" + idZona +
                ", Departamento='" + Departamento + '\'' +
                ", Ciudad='" + Ciudad + '\'' +
                ", Zona='" + Zona + '\'' +
                '}';
    }
}
