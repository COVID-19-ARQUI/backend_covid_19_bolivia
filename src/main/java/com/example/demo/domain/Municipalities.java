package com.example.demo.domain;

public class Municipalities {
    private Integer idMunicipality;
    private String municipality;

    public Municipalities() {
    }

    public Municipalities(Integer idMunicipality, String municipality) {
        this.idMunicipality = idMunicipality;
        this.municipality = municipality;
    }

    @Override
    public String toString() {
        return "Municipalities{" +
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
