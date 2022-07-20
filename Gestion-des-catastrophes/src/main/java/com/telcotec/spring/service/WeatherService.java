package com.telcotec.spring.service;

import com.telcotec.spring.entities.Weather;
import com.telcotec.spring.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService implements  IWeatherService{
    @Autowired
    public WeatherRepository wr;

    @Override
    public Weather addWeather(Weather a) {
        return wr.save(a);
    }
}
