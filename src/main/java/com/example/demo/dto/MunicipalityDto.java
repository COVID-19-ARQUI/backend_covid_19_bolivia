package com.example.demo.dto;

public class MunicipalityDto {
    private Integer idMunicipality;
    private String municipality;

    public MunicipalityDto(Integer idMunicipality, String municipality) {
        this.idMunicipality = idMunicipality;
        this.municipality = municipality;
    }

    public MunicipalityDto() {
    }

    @Override
    public String toString() {
        return "MunicipalityDto{" +
                "idMunicipality=" + idMunicipality +
                ", municipality='" + municipality + '\'' +
                '}';
    }

    public Integer getIdMunicipality() {
        return idMunicipality;
    }

    public void setIdMunicipality(Integer idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
}
