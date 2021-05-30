package com.example.demo.dto;


public class DataDto {

    private Integer idData;
    private Integer data;
    private String inDate;
    private Integer idLocation;
    private String datatype;

    public DataDto() {
    }

    public DataDto(Integer idData, Integer data, String inDate, Integer idLocation, String datatype) {
        this.idData = idData;
        this.data = data;
        this.inDate = inDate;
        this.idLocation = idLocation;
        this.datatype = datatype;
    }

    @Override
    public String toString() {
        return "DataDto{" +
                "idData=" + idData +
                ", data=" + data +
                ", inDate='" + inDate + '\'' +
                ", idLocation=" + idLocation +
                ", datatype='" + datatype + '\'' +
                '}';
    }

    public Integer getIdData() {
        return idData;
    }

    public void setIdData(Integer idData) {
        this.idData = idData;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

}
