package com.example.demo.domain;

public class Countries {
    private Integer idCountry;
    private String country;

    public Countries() {
    }

    public Countries(Integer idCountry, String country) {
        this.idCountry = idCountry;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "idCountry=" + idCountry +
                ", country='" + country + '\'' +
                '}';
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
