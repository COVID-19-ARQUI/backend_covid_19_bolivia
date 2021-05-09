package com.example.demo.dto;

import java.util.Date;

public class DailyDataDto {
    private String department;
    private String municipality;
    private Date inDate;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private Integer firstDose;
    private Integer secondDose;

    public DailyDataDto(String department, String municipality, Date inDate, Integer confirmed, Integer deaths, Integer recovered, Integer firstDose, Integer secondDose) {
        this.department = department;
        this.municipality = municipality;
        this.inDate = inDate;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.firstDose = firstDose;
        this.secondDose = secondDose;
    }

    public DailyDataDto() {
    }

    @Override
    public String toString() {
        return "DailyDataDto{" +
                "department='" + department + '\'' +
                ", municipality='" + municipality + '\'' +
                ", date=" + inDate +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", firstDose=" + firstDose +
                ", secondDose=" + secondDose +
                '}';
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

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getFirstDose() {
        return firstDose;
    }

    public void setFirstDose(Integer firstDose) {
        this.firstDose = firstDose;
    }

    public Integer getSecondDose() {
        return secondDose;
    }

    public void setSecondDose(Integer secondDose) {
        this.secondDose = secondDose;
    }
}
