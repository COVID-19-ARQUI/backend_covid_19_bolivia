package com.example.demo.domain;

import java.util.Date;

public class Views {
    private Integer idView;
    private String name;
    private Integer active;
    private Integer idUser;
    private Integer txUserId;
    private String txHost;
    private Date txDate;

    public Views() {
    }

    public Views(Integer idView, String name, Integer active, Integer idUser, Integer txUser, String txHost, Date txDate) {
        this.idView = idView;
        this.name = name;
        this.active = active;
        this.idUser = idUser;
        this.txUserId = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "Dashboard{" +
                "idDashboard=" + idView +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", idUser=" + idUser +
                ", txUser='" + txUserId + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }

    public Integer getIdView() {
        return idView;
    }

    public void setIdView(Integer idView) {
        this.idView = idView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getTxUserId() {
        return txUserId;
    }

    public void setTxUserId(Integer txUserId) {
        this.txUserId = txUserId;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }
}
