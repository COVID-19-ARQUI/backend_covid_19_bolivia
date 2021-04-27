package com.example.demo.domain;

import java.util.Date;

public class Graphic {
    private Integer idGraphic;
    private String name;
    private Integer active;
    private Integer idGraphicType;
    private Integer idView;
    private String txHost;
    private Integer txUser;
    private Date txDate;

    public Graphic() {
    }

    public Graphic(Integer idGraphic, String name, Integer active, Integer idGraphicType, Integer idView, String txHost, Integer txUser, Date txDate) {
        this.idGraphic = idGraphic;
        this.name = name;
        this.active = active;
        this.idGraphicType = idGraphicType;
        this.idView = idView;
        this.txHost = txHost;
        this.txUser = txUser;
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "Graphic{" +
                "idGraphic=" + idGraphic +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", idGraphicType=" + idGraphicType +
                ", idView=" + idView +
                ", txHost='" + txHost + '\'' +
                ", txUser=" + txUser +
                ", txDate=" + txDate +
                '}';
    }

    public Integer getIdGraphic() {
        return idGraphic;
    }

    public void setIdGraphic(Integer idGraphic) {
        this.idGraphic = idGraphic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getIdGraphicType() {
        return idGraphicType;
    }

    public void setIdGraphicType(Integer idGraphicType) {
        this.idGraphicType = idGraphicType;
    }

    public Integer getIdView() {
        return idView;
    }

    public void setIdView(Integer idView) {
        this.idView = idView;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Integer getTxUser() {
        return txUser;
    }

    public void setTxUser(Integer txUser) {
        this.txUser = txUser;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }
}
