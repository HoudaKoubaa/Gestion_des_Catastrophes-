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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Programme implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String libelleProgramme;
	
	@Enumerated(EnumType.STRING)
	private CategorieProgramme categorieProgramme;
	
	private String localisationProg;
	
	private String tuteurProg;
	
	private int nbrParticipant; 
	
	
	
	
	

}
