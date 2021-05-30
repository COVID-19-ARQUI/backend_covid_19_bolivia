package com.example.demo.domain;

public class Locations {
    private Integer idLocation;
    private Integer idDepartment;
    private Integer idMunicipality;
    private Integer idCountry;
    private Double latitude;
    private Double longitude;

    public Locations() {
    }

    public Locations(Integer idLocation, Integer idDepartment, Integer idMunicipality, Integer idCountry, Double latitude, Double longitude) {
        this.idLocation = idLocation;
        this.idDepartment = idDepartment;
        this.idMunicipality = idMunicipality;
        this.idCountry = idCountry;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "idLocation=" + idLocation +
                ", idDepartment=" + idDepartment +
                ", idMunicipality=" + idMunicipality +
                ", idCountry=" + idCountry +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
