package com.example.demo.service;

import com.example.demo.dao.DataRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dto.DataSimpleDto;
import com.example.demo.util.Modelado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PredictorService {
    private final DepartmentRepository departmentRepository;
    private final DataRepository dataRepository;

    @Autowired
    public PredictorService(DepartmentRepository departmentRepository, DataRepository dataRepository) {
        this.departmentRepository = departmentRepository;
        this.dataRepository = dataRepository;
    }

    public List<DataSimpleDto> dataPredicted(Integer idDepartment, Integer predictAmount) throws ParseException {
        List<DataSimpleDto> confirmed = departmentRepository.listSpecificDataByIdDepartment(1, idDepartment);
        List<DataSimpleDto> deaths = departmentRepository.listSpecificDataByIdDepartment(2, idDepartment);
        List<DataSimpleDto> recovered = departmentRepository.listSpecificDataByIdDepartment(3, idDepartment);

        List<DataSimpleDto> response = new ArrayList<>();
        response.addAll(showMatrix(confirmed, predictAmount));
        response.addAll(showMatrix(deaths, predictAmount));
        response.addAll(showMatrix(recovered, predictAmount));
        return response;
    }

    public List<DataSimpleDto> dataPredictedCountry(Integer idCountry, Integer predictAmount) throws ParseException {
        List<DataSimpleDto> confirmed = dataRepository.listSpecificDataByIdCountry(1, idCountry);
        List<DataSimpleDto> deaths = dataRepository.listSpecificDataByIdCountry(2, idCountry);
        List<DataSimpleDto> recovered = dataRepository.listSpecificDataByIdCountry(3, idCountry);

        List<DataSimpleDto> response = new ArrayList<>();
        response.addAll(showMatrix(confirmed, predictAmount));
        response.addAll(showMatrix(deaths, predictAmount));
        response.addAll(showMatrix(recovered, predictAmount));
        return response;
    }

    public List<DataSimpleDto> showMatrix(List<DataSimpleDto> data, Integer predictAmount) throws ParseException {
        Modelado modelado = new Modelado();
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(data.get(data.size() - 1).getInDate());
        double[][] as = new double[data.size()][1];
        List<DataSimpleDto> response = new ArrayList<>();

        data.forEach(dataSimpleDto -> as[data.indexOf(dataSimpleDto)][0] = dataSimpleDto.getData());
        double[][] result = modelado.pronosticar(as, 3, predictAmount);

        for (int i = 0; i < result.length; i++) {
            DataSimpleDto dataSimpleDto = new DataSimpleDto();
            dataSimpleDto.setData((int) result[i][0]);
            dataSimpleDto.setInDate(addAndSubtractDates(date1, i + 1));
            dataSimpleDto.setDatatype(data.get(1).getDatatype());
            response.add(dataSimpleDto);
        }

        data.addAll(response);
        return data;
    }

    public String addAndSubtractDates(Date date, int dias) {

//        String dateFormat = "yyyy-MM-dd";
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());

    }
}
