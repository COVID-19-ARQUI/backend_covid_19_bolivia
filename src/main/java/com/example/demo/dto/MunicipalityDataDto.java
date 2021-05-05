package com.example.demo.dto;

public class MunicipalityDataDto {
    private Integer data;
    private String municipality;
    private String type;

    public MunicipalityDataDto() {
    }

    @Override
    public String toString() {
        return "MunicipalityDataDto{" +
                "data=" + data +
                ", municipality='" + municipality + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Integer getDato() {
        return data;
    }

    public void setDato(Integer dato) {
        this.data = dato;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
