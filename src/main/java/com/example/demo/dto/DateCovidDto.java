package com.example.demo.dto;

public class DateCovidDto {
    private String fecha;
    private Integer dato;
    private String tipoDeDatos;

    public DateCovidDto() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    public String getTipoDeDatos() {
        return tipoDeDatos;
    }

    public void setTipoDeDatos(String tipoDeDatos) {
        this.tipoDeDatos = tipoDeDatos;
    }
}
