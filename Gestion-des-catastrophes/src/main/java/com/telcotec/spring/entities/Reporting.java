package com.telcotec.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Reporting implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titre;
	
	private String auteurRapport;
	
	@Enumerated(EnumType.STRING)
	private CategorieReporting categorieReporting;
	
	private String description;
	
	private Date dateRapport;
	
	private String documentRapport;

}
