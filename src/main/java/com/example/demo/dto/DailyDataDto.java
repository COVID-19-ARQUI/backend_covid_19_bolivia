package com.example.demo.dto;

import java.util.Date;

public class DailyDataDto {
    private String department;
    private String municipality;
    private Date date;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private Integer actives;
    private Integer vaccinated;

    public DailyDataDto(String department, String municipality, Date date, Integer confirmed, Integer deaths, Integer recovered, Integer actives, Integer vaccinated) {
        this.department = department;
        this.municipality = municipality;
        this.date = date;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.actives = actives;
        this.vaccinated = vaccinated;
    }

    public DailyDataDto() {
    }

    @Override
    public String toString() {
        return "DataDto{" +
                "department='" + department + '\'' +
                ", municipality='" + municipality + '\'' +
                ", date=" + date +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", actives=" + actives +
                ", vaccinated=" + vaccinated +
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Integer getActives() {
        return actives;
    }

    public void setActives(Integer actives) {
        this.actives = actives;
    }

    public Integer getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Integer vaccinated) {
        this.vaccinated = vaccinated;
    }
}
