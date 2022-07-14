package com.telcotec.spring.service;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherService {
 private OkHttpClient client;
 private Response response;
 private String cityname;
 String unit;
 private String API="1a79a0a73532a753db66da242befaa84";
 
 
 public JSONObject getweather() throws JSONException {
	 client = new OkHttpClient();
	 Request request= new Request.Builder()
	.url("https://api.openweathermap.org/data/2.5/weather?q="+getCityname()+"&units="+getUnit()+"&appid=1a79a0a73532a753db66da242befaa84").build();
 	
	 try {
		response = client.newCall(request).execute();
		return new JSONObject(response.body().string());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return null;
	 
	 
 }
 public JSONArray returnWeatherArray() throws JSONException {
	 JSONArray weatherArray= getweather().getJSONArray("weather");
	 return weatherArray;
 }

 public JSONArray returnMain() throws JSONException {
	 JSONArray main= getweather().getJSONArray("main");
	 return main;
 }
 
 
 public JSONArray returnWind() throws JSONException {
	 JSONArray wind= getweather().getJSONArray("wind");
	 return wind;
 }
 
 public JSONArray returnSys() throws JSONException {
	 JSONArray sys= getweather().getJSONArray("sys");
	 return sys;
 }
public String getCityname() {
	return cityname;
}


public void setCityname(String cityname) {
	this.cityname = cityname;
}


public String getUnit() {
	return unit;
}


public void setUnit(String unit) {
	this.unit = unit;
}



 
 
}
