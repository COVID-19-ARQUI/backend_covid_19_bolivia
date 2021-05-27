package com.example.demo.dto;

import org.springframework.data.relational.core.sql.In;

import java.util.Date;

public class DataLoadedDto {
    private Integer data;
    private Date inDate;
    private String dataType;
    private String country;
    private String department;
    private String municipality;
    public DataLoadedDto(){

    }

    public DataLoadedDto(Integer data, Date inDate, String dataType, String country, String department, String municipality) {
        this.data = data;
        this.inDate = inDate;
        this.dataType = dataType;
        this.country = country;
        this.department = department;
        this.municipality = municipality;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    @Override
    public String toString() {
        return "DataLoadedDto{" +
                "data='" + data + '\'' +
                ", inDate=" + inDate +
                ", country='" + country + '\'' +
                ", type='" + dataType + '\'' +
                ", department='" + department + '\'' +
                ", municipality='" + municipality + '\'' +
                '}';
    }
}
