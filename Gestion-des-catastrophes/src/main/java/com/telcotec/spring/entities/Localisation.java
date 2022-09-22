package com.telcotec.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="Localisation")
public class Localisation implements Serializable{
	@Id
    @Column(name = "Id") 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private String id;
	private String city;
	private double latitude;
	private double longitude;
	
	public Localisation(String city, double latitude, double longitude, String id) {
		super();
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public Localisation() {}


	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Location [city=" + city + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	public void setId(String randomUUID) {
		this.id = randomUUID;
	}
}
