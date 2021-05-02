package com.example.demo.dto;

public class DataCovidMunicipioDto {
    private Integer dato;
    private String fecha;

    public DataCovidMunicipioDto() {

    }

    public Integer getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "DataCovidMunicipioDto{" +
                "dato=" + dato +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
