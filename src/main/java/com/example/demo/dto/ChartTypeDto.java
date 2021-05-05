package com.example.demo.dto;

public class ChartTypeDto {
    private Integer idChartType;
    private String name;
    private int active;

    public ChartTypeDto(Integer idChartType, String name, int active) {
        this.idChartType = idChartType;
        this.name = name;
        this.active = active;
    }

    public ChartTypeDto() {
    }

    public Integer getIdChartType() {
        return idChartType;
    }

    public void setIdChartType(Integer idChartType) {
        this.idChartType = idChartType;
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

    @Override
    public String toString() {
        return "Graphictype{" +
                "idGraphictype=" + idChartType +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
