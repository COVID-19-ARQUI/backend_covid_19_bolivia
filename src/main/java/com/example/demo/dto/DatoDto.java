package com.example.demo.dto;


import java.util.Date;

public class DatoDto {

    private Integer idDato;
    private Integer dato;
    private String fecha;
    private Integer zonaId;
    private String tipoDeDato;
    private Integer paisId;

    public DatoDto() {
    }

    public Integer getIdDato() {
        return idDato;
    }

    public void setIdDato(Integer idDato) {
        this.idDato = idDato;
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

    public Integer getZonaId() {
        return zonaId;
    }

    public void setZonaId(Integer zonaId) {
        this.zonaId = zonaId;
    }

    public String getTipoDeDato() {
        return tipoDeDato;
    }

    public void setTipoDeDato(String tipoDeDato) {
        this.tipoDeDato = tipoDeDato;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }
}
