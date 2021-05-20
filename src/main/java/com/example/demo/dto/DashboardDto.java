package com.example.demo.dto;

public class DashboardDto {
    private Integer idDashboard;
    private String name;
    private Integer active;
    private Integer idUser;

    public DashboardDto() {
    }

    public DashboardDto(Integer idDashboard, String name, Integer active, Integer idUser) {
        this.idDashboard = idDashboard;
        this.name = name;
        this.active = active;
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "DashboardDto{" +
                "idDashboard=" + idDashboard +
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

    public Integer getIdDashboard() {
        return idDashboard;
    }

    public void setIdDashboard(Integer idDashboard) {
        this.idDashboard = idDashboard;
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
