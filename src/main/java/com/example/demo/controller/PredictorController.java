package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataSimpleDto;
import com.example.demo.dto.RegisterUserDto;
import com.example.demo.service.PredictorService;
import com.example.demo.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/predict")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PredictorController {
    private PredictorService predictorService;

    @Autowired
    public PredictorController(PredictorService predictorService) {
        this.predictorService = predictorService;
    }

    @RequestMapping(value = "/department/{departmentid}",params = {"cant"},method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> predictdata(@RequestParam ("cant")  Integer cant, @PathVariable("departmentid") Integer departmentId ) throws ParseException {
        return predictorService.datapredicted(departmentId, cant);
    }
}
