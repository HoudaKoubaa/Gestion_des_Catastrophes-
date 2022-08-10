package com.telcotec.spring.service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.telcotec.spring.entities.Localisation;
@Service
public class LocationService {

	private List<Localisation> locations = new ArrayList<>();

	public Localisation setLocation(Localisation location) {
		location.setId(UUID.randomUUID().toString());
		this.locations.add(location);
		return location;
	}

	public List<Localisation> getAll() {
	    return this.locations;
    }
}
