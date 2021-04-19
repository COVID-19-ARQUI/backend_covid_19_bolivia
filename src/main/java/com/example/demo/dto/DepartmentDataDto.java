package com.example.demo.dto;

public class DepartmentDataDto {
    private Integer dato;
    private String fecha;
    private String tipoDeDato;

    public DepartmentDataDto() {
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

    public String getTipoDeDato() {
        return tipoDeDato;
    }

    public void setTipoDeDato(String tipoDeDato) {
        this.tipoDeDato = tipoDeDato;
    }

    @Override
    public String toString() {
        return "DepartmentDataDto{" +
                "dato=" + dato +
                ", fecha='" + fecha + '\'' +
                ", tipoDeDato='" + tipoDeDato + '\'' +
                '}';
    }
}
