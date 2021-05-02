package com.example.demo.domain;

public class ChartTypes {
    private Integer idChartType;
    private String type;

    public ChartTypes() {
    }

    public ChartTypes(Integer idChartType, String type) {
        this.idChartType = idChartType;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ChartTypes{" +
                "idChartType=" + idChartType +
                ", type='" + type + '\'' +
                '}';
    }

    public Integer getIdChartType() {
        return idChartType;
    }

    public void setIdChartType(Integer idChartType) {
        this.idChartType = idChartType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
