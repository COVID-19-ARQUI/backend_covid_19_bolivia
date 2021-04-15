package com.example.demo.dao;

import com.example.demo.dto.DepartmentDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

@Mapper
public interface DepartmentRepository {
    public List<DepartmentDto> getDepartments();
}
