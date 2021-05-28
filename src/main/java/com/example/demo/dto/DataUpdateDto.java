package com.example.demo.dto;

import java.util.Date;

public class DataUpdateDto {
    private Integer data;
    private Date inDate;
    private Integer dataType;
    private Integer idcountry;
    private Integer iddepartment;
    private String idmunicipality;
    public DataUpdateDto(){

    }

    public DataUpdateDto(Integer data, Date inDate, Integer dataType, Integer idcountry, Integer iddepartment, String idmunicipality) {
        this.data = data;
        this.inDate = inDate;
        this.dataType = dataType;
        this.idcountry = idcountry;
        this.iddepartment = iddepartment;
        this.idmunicipality = idmunicipality;
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

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getIdcountry() {
        return idcountry;
    }

    public void setIdcountry(Integer idcountry) {
        this.idcountry = idcountry;
    }

    public Integer getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(Integer iddepartment) {
        this.iddepartment = iddepartment;
    }

    public String getIdmunicipality() {
        return idmunicipality;
    }

    public void setIdmunicipality(String idmunicipality) {
        this.idmunicipality = idmunicipality;
    }
}
