package com.example.demo.dto;

import com.example.demo.domain.View;

public class ViewDto {
    private Integer idView;
    private String name;
    private String txUser;
    private String txHost;
    private String txDate;
    private int active;
    private int idDashboard;

    public ViewDto() {
    }

    public ViewDto(Integer idView, String name, String txUser, String txHost, String txDate, int active, int idDashboard) {
        this.idView = idView;
        this.name = name;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.active = active;
        this.idDashboard = idDashboard;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getIdDashboard() {
        return idDashboard;
    }

    public void setIdDashboard(int idDashboard) {
        this.idDashboard = idDashboard;
    }

    @Override
    public String toString() {
        return "ViewDto{" +
                "idView=" + idView +
                ", name='" + name + '\'' +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate='" + txDate + '\'' +
                ", active=" + active +
                '}';
    }
}

