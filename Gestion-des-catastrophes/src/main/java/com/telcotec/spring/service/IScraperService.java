package com.telcotec.spring.service;

import java.util.Set;

import com.telcotec.spring.entities.WeatherDataDto;

public interface IScraperService {
	 public Set<WeatherDataDto> getVehicleByModel(String vehicleModel);

}
