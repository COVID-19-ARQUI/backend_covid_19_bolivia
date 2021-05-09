package com.example.demo.domain;

import java.util.Date;

public class Data {
    private Integer idData;
    private Integer data;
    private Date inDate;
    private Integer idLocation;
    private Integer idDatatype;
    private Integer active;
    private String txUserId;
    private String txHost;
    private Date txDate;

    public Data() {
    }

    public Data(Integer idData, Integer data, Date inDate, Integer idLocation, Integer idDatatype, Integer active, String txUserId, String txHost, Date txDate) {
        this.idData = idData;
        this.data = data;
        this.inDate = inDate;
        this.idLocation = idLocation;
        this.idDatatype = idDatatype;
        this.active = active;
        this.txUserId = txUserId;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "Data{" +
                "idData=" + idData +
                ", data='" + data + '\'' +
                ", inDate=" + inDate +
                ", idLocation=" + idLocation +
                ", idDatatype=" + idDatatype +
                ", active=" + active +
                ", txUserId='" + txUserId + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }

    public Integer getIdData() {
        return idData;
    }

    public void setIdData(Integer idData) {
        this.idData = idData;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Integer getIdDatatype() {
        return idDatatype;
    }

    public void setIdDatatype(Integer idDatatype) {
        this.idDatatype = idDatatype;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getTxUserId() {
        return txUserId;
    }

    public void setTxUserId(String txUserId) {
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
