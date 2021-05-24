package com.example.demo.dto;


public class ChartsDto {
    private Integer idChart;
    private String name;
    private int active;
    private Integer idView;
    private int idChartType;

    public ChartsDto() {
    }


    public ChartsDto(Integer idChart, String name, int active, Integer idView, int idChartType) {
        this.idChart = idChart;
        this.name = name;
        this.active = active;
        this.idView = idView;
        this.idChartType = idChartType;
    }

    @Override
    public String toString() {
        return "GraphicDto{" +
                "idChart=" + idChart +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", idView=" + idView +
                ", idTypeGraphic=" + idChartType +
                '}';
    }

    public Integer getIdChart() {
        return idChart;
    }

    public void setIdChart(Integer idChart) {
        this.idChart = idChart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Integer getIdView() {
        return idView;
    }

    public void setIdView(Integer idView) {
        this.idView = idView;
    }

    public int getIdChartType() {
        return idChartType;
    }

    public void setIdChartType(int idChartType) {
        this.idChartType = idChartType;
    }


}

