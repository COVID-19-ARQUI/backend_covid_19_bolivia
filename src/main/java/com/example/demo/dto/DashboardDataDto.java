package com.example.demo.dto;

import java.util.List;

public class DashboardDataDto {

    private Integer idDepartment;
    private String department;
    private List<DataDto> dataDto;

    public DashboardDataDto() {
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

    public List<DataDto> getDataDto() {
        return dataDto;
    }

    public void setDataDto(List<DataDto> dataDto) {
        this.dataDto = dataDto;
    }
}
