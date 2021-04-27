package com.example.demo.domain;

import java.util.Date;

public class View {
    private Integer idView;
    private String name;
    private Integer active;
    private Integer idDashboard;
    private String txUser;
    private String txHost;
    private Date txDate;

    public View() {
    }

    public View(Integer idView, String name, Integer active, Integer idDashboard, String txUser, String txHost, Date txDate) {
        this.idView = idView;
        this.name = name;
        this.active = active;
        this.idDashboard = idDashboard;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "View{" +
                "idView=" + idView +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", idDashboard=" + idDashboard +
                ", txUser='" + txUser + '\'' +
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

    public Integer getIdDashboard() {
        return idDashboard;
    }

    public void setIdDashboard(Integer idDashboard) {
        this.idDashboard = idDashboard;
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
