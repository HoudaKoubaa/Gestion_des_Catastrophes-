package com.telcotec.spring.controlleur;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telcotec.spring.entities.WeatherDataDto;
import com.telcotec.spring.service.IScraperService;

@RestController
@RequestMapping(path = "/test/")
public class ScraperController {
	
	@Autowired
    IScraperService scraperService;

    @GetMapping(path = "/{vehicleModel}")
    public Set<WeatherDataDto> getVehicleByModel(@PathVariable String vehicleModel) {
        return  scraperService.getVehicleByModel(vehicleModel);
    }

}
