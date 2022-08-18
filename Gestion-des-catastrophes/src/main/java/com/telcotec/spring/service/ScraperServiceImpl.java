package com.telcotec.spring.service;

import org.springframework.stereotype.Service;

import com.telcotec.spring.entities.WeatherDataDto;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ScraperServiceImpl implements IScraperService{
	
    //Reading data from property file to a list
    @Value("#{'${website.urls}'.split(',')}")
    List<String> urls;

    @Override
    public Set<WeatherDataDto> getVehicleByModel(String vehicleModel) {
        //Using a set here to only store unique elements
        Set<WeatherDataDto> weatherDataDto = new HashSet<>();
        //Traversing through the urls
        for (String url: urls) {

            if (url.contains("ikman")) {
                //method to extract data from Ikman.lk
                extractDataFromIkman(weatherDataDto, url + vehicleModel);
            } else if (url.contains("riyasewana")) {
               //method to extract Data from riyasewana.com
                extractDataFromRiyasewana(weatherDataDto, url + vehicleModel);
            }

        }

        return weatherDataDto;
    }

    private void extractDataFromRiyasewana(Set<WeatherDataDto> weatherDataDtos, String url) {

        try {
            //loading the HTML to a Document Object
            Document document = Jsoup.connect(url).get();
            //Selecting the element which contains the ad list
            Element element = document.getElementById("content");
            //getting all the <a> tag elements inside the content div tag
            Elements elements = element.getElementsByTag("a");
           //traversing through the elements
            for (Element ads: elements) {
            	WeatherDataDto weatherDataDto = new WeatherDataDto();

                if (!StringUtils.isEmpty(ads.attr("title")) ) {
                    //mapping data to the model class
                	weatherDataDto.setTitle(ads.attr("title"));
                	weatherDataDto.setUrl(ads.attr("href"));
                }
                if (weatherDataDto.getUrl() != null) weatherDataDtos.add(weatherDataDto);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void extractDataFromIkman(Set<WeatherDataDto> weatherDataDtos, String url) {
        try {
            //loading the HTML to a Document Object
            Document document = Jsoup.connect(url).get();
//Selecting the element which contains the ad list
            Element element = document.getElementsByClass("list--3NxGO").first();
            //getting all the <a> tag elements inside the list-       -3NxGO class
            Elements elements = element.getElementsByTag("a");

            for (Element ads: elements) {

            	WeatherDataDto weatherDataDto = new WeatherDataDto();

                if (StringUtils.isNotEmpty(ads.attr("href"))) {
                   //mapping data to our model class
                	weatherDataDto.setTitle(ads.attr("title"));
                	weatherDataDto.setUrl("https://ikman.lk"+ ads.attr("href"));
                }
                if (weatherDataDto.getUrl() != null) weatherDataDtos.add(weatherDataDto);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}