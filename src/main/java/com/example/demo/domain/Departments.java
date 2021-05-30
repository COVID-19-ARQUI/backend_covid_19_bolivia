package com.example.demo.domain;

public class Departments {
    private Integer idDepartment;
    private String department;

    public Departments() {
    }

    public Departments(Integer idDepartment, String department) {
        this.idDepartment = idDepartment;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", department='" + department + '\'' +
                '}';
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

