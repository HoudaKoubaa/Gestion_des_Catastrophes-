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
	private double altitude;
	private double latitude;
	private double longitude;
	
	public Localisation(double altitude, double latitude, double longitude, String id) {
		super();
		this.altitude = altitude;
		this.latitude = latitude;
		this.longitude = longitude;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public Localisation() {}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

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
		return "Location [altitude=" + altitude + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	public void setId(String randomUUID) {
		this.id = randomUUID;
	}
}
