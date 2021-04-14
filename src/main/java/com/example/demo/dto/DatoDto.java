package com.example.demo.dto;

import com.example.demo.domain.Dato;

import java.util.Date;

public class  DatoDto {

    private Integer idDato;
    private String dato;
    private Date fecha;
    private String tipoDeDato;
    private String txUser;
    private String txHost;
    private String txDate;
    private int idZona;

    public DatoDto(){}



    public DatoDto(Integer idDato, String dato, Date fecha, String tipoDeDato, String txUser, String txHost, String txDate, int idZona) {
        this.idDato = idDato;
        this.dato = dato;
        this.fecha = fecha;
        this.tipoDeDato = tipoDeDato;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.idZona = idZona;
    }

    public Integer getIdDato() {
        return idDato;
    }

    public void setIdDato(Integer idDato) {
        this.idDato = idDato;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoDeDato() {
        return tipoDeDato;
    }

    public void setTipoDeDato(String tipoDeDato) {
        this.tipoDeDato = tipoDeDato;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public String getTxDate() {
        return txDate;
    }

    public void setTxDate(String txDate) {
        this.txDate = txDate;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    @Override
    public String toString() {
        return "DatoDto{" +
                "idDato=" + idDato +
                ", dato='" + dato + '\'' +
                ", fecha=" + fecha +
                ", tipoDeDato='" + tipoDeDato + '\'' +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate='" + txDate + '\'' +
                ", idZona=" + idZona +
                '}';
    }
}
