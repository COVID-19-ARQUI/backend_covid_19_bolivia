package com.example.demo.domain;

public class DatoGraphic {
    private Integer idDatoGraphic;
    private Integer idDato;
    private Integer idGraphic;

    public DatoGraphic() {
    }

    public DatoGraphic(Integer idDatoGraphic, Integer idDato, Integer idGraphic) {
        this.idDatoGraphic = idDatoGraphic;
        this.idDato = idDato;
        this.idGraphic = idGraphic;
    }

    @Override
    public String toString() {
        return "DatoGraphic{" +
                "idDatoGraphic=" + idDatoGraphic +
                ", idDato=" + idDato +
                ", idGraphic=" + idGraphic +
                '}';
    }

    public Integer getIdDatoGraphic() {
        return idDatoGraphic;
    }

    public void setIdDatoGraphic(Integer idDatoGraphic) {
        this.idDatoGraphic = idDatoGraphic;
    }

    public Integer getIdDato() {
        return idDato;
    }

    public void setIdDato(Integer idDato) {
        this.idDato = idDato;
    }

    public Integer getIdGraphic() {
        return idGraphic;
    }

    public void setIdGraphic(Integer idGraphic) {
        this.idGraphic = idGraphic;
    }
}
