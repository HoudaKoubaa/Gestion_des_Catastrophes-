package com.telcotec.spring.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telcotec.spring.entities.Localisation;
import com.telcotec.spring.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {
	@Autowired
	private LocationService locationService;
	
	@PostMapping(value = "/")
	public Localisation setLocation(@RequestBody Localisation location) {
        return locationService.setLocation(location);
    }

    @GetMapping(value = "/")
    public List<Localisation> getAll() {
	    return locationService.getAll();
    }
}
