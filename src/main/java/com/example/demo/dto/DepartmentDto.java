package com.example.demo.dto;

public class DepartmentDto {
    private Integer idDepartment;
    private String department;

    public DepartmentDto() {
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

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "idDepartment=" + idDepartment +
                ", department='" + department + '\'' +
                '}';
    }
}
