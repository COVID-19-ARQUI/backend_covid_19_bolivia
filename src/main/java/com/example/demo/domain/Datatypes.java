package com.example.demo.domain;

public class Datatypes {
    private Integer idDatatype;
    private String type;

    public Datatypes() {
    }

    public Datatypes(Integer idDatatype, String type) {
        this.idDatatype = idDatatype;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Datatype{" +
                "idDatatype=" + idDatatype +
                ", type='" + type + '\'' +
                '}';
    }

    public Integer getIdDatatype() {
        return idDatatype;
    }

    public void setIdDatatype(Integer idDatatype) {
        this.idDatatype = idDatatype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
