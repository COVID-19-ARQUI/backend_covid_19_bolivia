package com.example.demo.domain;

import java.util.Date;

public class Charts {
    private Integer idChart;
    private String name;
    private Integer active;
    private Integer idChartsType;
    private Integer idView;
    private Integer txUserId;
    private String txHost;
    private Date txDate;

    public Charts() {
    }

    public Charts(Integer idChart, String name, Integer active, Integer idChartsType, Integer idView, Integer txUserId, String txHost, Date txDate) {
        this.idChart = idChart;
        this.name = name;
        this.active = active;
        this.idChartsType = idChartsType;
        this.idView = idView;
        this.txUserId = txUserId;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "Charts{" +
                "idChart=" + idChart +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", idChartsType=" + idChartsType +
                ", idView=" + idView +
                ", txUserId=" + txUserId +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }

    public Integer getIdChart() {
        return idChart;
    }

    public void setIdChart(Integer idChart) {
        this.idChart = idChart;
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

    public Integer getIdChartsType() {
        return idChartsType;
    }

    public void setIdChartsType(Integer idChartsType) {
        this.idChartsType = idChartsType;
    }

    public Integer getIdView() {
        return idView;
    }

    public void setIdView(Integer idView) {
        this.idView = idView;
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
