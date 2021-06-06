package com.example.demo.controller;

import com.example.demo.dto.DataSimpleDto;
import com.example.demo.service.PredictorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/predict")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PredictorController {
    private final PredictorService predictorService;

    @Autowired
    public PredictorController(PredictorService predictorService) {
        this.predictorService = predictorService;
    }

    @RequestMapping(value = "/department/{idDepartment}", params = {"cant"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> predictData(@RequestParam("cant") Integer cant, @PathVariable("idDepartment") Integer departmentId) throws ParseException {
        return predictorService.dataPredicted(departmentId, cant);
    }

    @RequestMapping(value = "/country/{idCountry}", params = {"cant"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> predictDataCountry(@RequestParam("cant") Integer cant, @PathVariable("idCountry") Integer idCountry) throws ParseException {
        return predictorService.dataPredictedCountry(idCountry, cant);
    }

    //dataPredictedCountrylineal
    @RequestMapping(value = "/country/lineal/{idCountry}", params = {"cant"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> predictDataCountrylineal(@RequestParam("cant") Integer cant, @PathVariable("idCountry") Integer idCountry) throws ParseException {
        return predictorService.dataPredictedCountrylineal(idCountry, cant);
    }
    //dep
    @RequestMapping(value = "/cities/lineal/{idDep}", params = {"cant"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> predictDataDeplineal(@RequestParam("cant") Integer cant, @PathVariable("idDep") Integer idDep) throws ParseException {
        return predictorService.dataPredictedDeparmetlineal(idDep, cant);
    }

    //dataPredictedCountrylog
    @RequestMapping(value = "/country/log/{idCountry}", params = {"cant"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> predictDataCountrylog(@RequestParam("cant") Integer cant, @PathVariable("idCountry") Integer idCountry) throws ParseException {
        return predictorService.dataPredictedCountrylog(idCountry, cant);
    }
    //dep
    @RequestMapping(value = "/cities/log/{idDep}", params = {"cant"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> predictDataDeplog(@RequestParam("cant") Integer cant, @PathVariable("idDep") Integer idDep) throws ParseException {
        return predictorService.dataPredictedDeparmetlog(idDep, cant);
    }

    //dataPredictedCountryexp
    @RequestMapping(value = "/country/exp/{idCountry}", params = {"cant"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> predictDataCountryexp(@RequestParam("cant") Integer cant, @PathVariable("idCountry") Integer idCountry) throws ParseException {
        return predictorService.dataPredictedCountryexp(idCountry, cant);
    }
    //dep
    @RequestMapping(value = "/cities/exp/{idDep}", params = {"cant"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> predictDataDepExp(@RequestParam("cant") Integer cant, @PathVariable("idDep") Integer idDep) throws ParseException {
        return predictorService.dataPredictedDeparmetlexp(idDep, cant);
    }

    //dataPredictedCountrypow
    @RequestMapping(value = "/country/pow/{idCountry}", params = {"cant"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> predictDataCountrypow(@RequestParam("cant") Integer cant, @PathVariable("idCountry") Integer idCountry) throws ParseException {
        return predictorService.dataPredictedCountrypow(idCountry, cant);
    }
    //dep
    @RequestMapping(value = "/cities/pow/{idDep}", params = {"cant"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> predictDataDepPow(@RequestParam("cant") Integer cant, @PathVariable("idDep") Integer idDep) throws ParseException {
        return predictorService.dataPredictedDeparmetpow(idDep, cant);
    }

}
