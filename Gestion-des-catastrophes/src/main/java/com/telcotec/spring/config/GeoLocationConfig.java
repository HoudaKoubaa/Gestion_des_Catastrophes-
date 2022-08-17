package com.telcotec.spring.config;

import org.apache.commons.logging.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import com.maxmind.geoip2.DatabaseReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class GeoLocationConfig {
	
	private static DatabaseReader reader = null ;
	private final ResourceLoader resourceloader;
	
	public GeoLocationConfig(ResourceLoader resourceloader) {
		this.resourceloader= resourceloader;
	}
	
	@Bean
	public DatabaseReader databasereader() {
			Log.info("GeoLocationConfig traying to load  geolite contry");
		
	}

}
