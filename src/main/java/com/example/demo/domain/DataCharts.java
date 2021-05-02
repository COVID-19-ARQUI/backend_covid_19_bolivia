package com.example.demo.domain;

public class DataCharts {
    private Integer idDataChart;
    private Integer idData;
    private Integer idChart;

    public DataCharts() {
    }

    public DataCharts(Integer idDataChart, Integer idData, Integer idChart) {
        this.idDataChart = idDataChart;
        this.idData = idData;
        this.idChart = idChart;
    }

    @Override
    public String toString() {
        return "DataCharts{" +
                "idDataChart=" + idDataChart +
                ", idData=" + idData +
                ", idChart=" + idChart +
                '}';
    }

    public Integer getIdDataChart() {
        return idDataChart;
    }

    public void setIdDataChart(Integer idDataChart) {
        this.idDataChart = idDataChart;
    }

    public Integer getIdData() {
        return idData;
    }

    public void setIdData(Integer idData) {
        this.idData = idData;
    }

    public Integer getIdChart() {
        return idChart;
    }

    public void setIdChart(Integer idChart) {
        this.idChart = idChart;
    }
}
