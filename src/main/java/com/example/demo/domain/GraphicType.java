package com.example.demo.domain;

public class GraphicType {
    private Integer idGraphicType;
    private String name;
    private Integer active;

    public GraphicType() {
    }

    public GraphicType(Integer idGraphicType, String name, Integer active) {
        this.idGraphicType = idGraphicType;
        this.name = name;
        this.active = active;
    }

    @Override
    public String toString() {
        return "GraphicType{" +
                "idGraphicType=" + idGraphicType +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }

    public Integer getIdGraphicType() {
        return idGraphicType;
    }

    public void setIdGraphicType(Integer idGraphicType) {
        this.idGraphicType = idGraphicType;
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
