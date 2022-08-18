package com.telcotec.spring.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PUBLIC)
public class WeatherDataDto {

	String title;
    String url;
}
	