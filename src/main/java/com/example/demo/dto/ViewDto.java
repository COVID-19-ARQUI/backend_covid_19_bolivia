package com.example.demo.dto;

public class ViewDto {
    private Integer idView;
    private String name;
    private Integer active;
    private Integer idUser;

    public ViewDto() {
    }

    public ViewDto(Integer idView, String name, Integer active, Integer idUser) {
        this.idView = idView;
        this.name = name;
        this.active = active;
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "DashboardDto{" +
                "idDashboard=" + idView +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", idUser=" + idUser +
                '}';
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdView() {
        return idView;
    }

    public void setIdView(Integer idView) {
        this.idView = idView;
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
}
