package com.example.demo.domain;

public class Locations {
    private Integer idLocation;
    private Integer idDepartment;
    private Integer idMunicipality;
    private Integer idCountry;

    public Locations(Integer idLocation, Integer idDepartment, Integer idMunicipality, Integer idCountry) {
        this.idLocation = idLocation;
        this.idDepartment = idDepartment;
        this.idMunicipality = idMunicipality;
        this.idCountry = idCountry;
    }

    public Locations() {
    }

    @Override
    public String toString() {
        return "Locations{" +
                "idLocation=" + idLocation +
                ", idDepartment=" + idDepartment +
                ", idMunicipality=" + idMunicipality +
                ", idCountry=" + idCountry +
                '}';
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public Integer getIdMunicipality() {
        return idMunicipality;
    }

    public void setIdMunicipality(Integer idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }
}
