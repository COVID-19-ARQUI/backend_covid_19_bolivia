package com.example.demo.domain;

import com.example.demo.dto.DashboardDto;

import java.util.Date;

public class Dashboard {
    private Integer idDashboard;
    private String name;
    private Integer active;
    private Integer idUser;
    private String txUser;
    private String txHost;
    private Date txDate;

    public Dashboard() {
    }

    public Dashboard(Integer idDashboard, String name, Integer active, Integer idUser, String txUser, String txHost, Date txDate) {
        this.idDashboard = idDashboard;
        this.name = name;
        this.active = active;
        this.idUser = idUser;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "Dashboard{" +
                "idDashboard=" + idDashboard +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", idUser=" + idUser +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }

    public Integer getIdDashboard() {
        return idDashboard;
    }

    public void setIdDashboard(Integer idDashboard) {
        this.idDashboard = idDashboard;
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

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }
}
