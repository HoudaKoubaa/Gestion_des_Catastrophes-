package com.telcotec.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Getter
@Setter
public class Weather implements Serializable {

    private static final long serialVersionUID = 7406210628182440902L;

    @Id
    @Column(name = "idweather")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idweather;
    
    @Column(name = "id", nullable = false) 
	private int id;
    private String weatherDescription;
    private double lon;
    private String name;
    private double lat;
    private double temp_min;
    private double temp_max;
    private double humidity;
    private double temp;
    private String icon;
    private double speed;
   

    @Bean
    public Weather weather() {
        return new Weather();
    }

    public Weather() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Weather(Weather weather) {
        // TODO Auto-generated constructor stub
    }

    public double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(double lat) {
        this.lat = lat;
    }


    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        Map<String, Object> weather = weatherEntries.get(0);
        setId((int)weather.get("id"));
        setWeatherDescription((String) weather.get("description"));
        setIcon((String) weather.get("icon"));
    }

    @JsonProperty("lon")
    public double getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(double lon) {
        this.lon = lon;
    }

    @JsonProperty("coord")
    public void setCoord(Map<String, Integer> coord) {
        setLon((double) coord.get("lon"));
        setLat((double) coord.get("lat"));

    }
    
    @JsonProperty("temp_min")
    public double getTemp_min() {
        return temp_min;
    }
    @JsonProperty("temp_min")
    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }
    @JsonProperty("temp_max")
    public double getTemp_max() {
        return temp_max;
    }
    @JsonProperty("temp_max")
    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }
    @JsonProperty("humidity")
    public double getHumidity() {
        return humidity;
    }
    @JsonProperty("humidity")
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
    @JsonProperty("main")
    public void setmain(Map<String, Integer> main) {
    	setTemp((double) main.get("temp"));
        setTemp_min((double) main.get("temp_min"));
        setTemp_max((double) main.get("temp_max"));
        setHumidity((double) main.get("humidity"));

    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonProperty("temp")
	public double getTemp() {
		return temp;
	}
	@JsonProperty("temp")
	public void setTemp(double temp) {
		this.temp = temp;
	}
	@JsonProperty("icon")
	public String getIcon() {
		return icon;
	}
	@JsonProperty("icon")
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@JsonProperty("speed")
	public double getSpeed() {
		return speed;
	}
	@JsonProperty("speed")
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	 @JsonProperty("wind")
	    public void setwind(Map<String, Integer> wind) {
		 setSpeed((double) wind.get("speed"));
	    }
	
}
