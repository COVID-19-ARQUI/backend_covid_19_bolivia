package com.example.demo.dto;

public class GraphicTypeDto {
    private Integer idGraphictype;
    private String name;
    private int active;

    public GraphicTypeDto(Integer idGraphictype, String name, int active) {
        this.idGraphictype = idGraphictype;
        this.name = name;
        this.active = active;
    }

    public GraphicTypeDto() {
    }

    public Integer getIdGraphictype() {
        return idGraphictype;
    }

    public void setIdGraphictype(Integer idGraphictype) {
        this.idGraphictype = idGraphictype;
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
                "idGraphictype=" + idGraphictype +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
