package com.example.demo.dto;

public class GeneralStatisticsDto {
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private Integer actives;
    private Integer vaccinated;

    public GeneralStatisticsDto() {
    }

    public GeneralStatisticsDto(Integer confirmed, Integer deaths, Integer recovered, Integer actives, Integer vaccinated) {
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.actives = actives;
        this.vaccinated = vaccinated;
    }

    @Override
    public String toString() {
        return "GeneralData{" +
                "confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", actives=" + actives +
                ", vaccinated=" + vaccinated +
                '}';
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
