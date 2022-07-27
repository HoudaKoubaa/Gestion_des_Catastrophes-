package com.telcotec.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
//@Data
@Table(name="User")
public class user implements Serializable{
	public enum Role {
		Administrateur,DGPC,BNSP,ANAM,DGRE,CONASUR,SAP
	}
	
	public enum Genre {
		Homme,Femme,autre
	}
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="id")
private int id;

@Column(name="cin")
@NonNull
private int cin;

@Column(name="nom")
@NonNull
private String nom;


@Column(name="prenom")
@NonNull
private String prenom;

@Enumerated(EnumType.STRING)
@Column(name="role")
@NonNull
private Role role;


@Column(name="email")
@NonNull
private String email;


@Column(name="mdp")
@NonNull
private String mdp;


@Column(name="dateNaiss")
private Date DadateNaiss;
@Enumerated(EnumType.STRING)
@Column(name="sexe")
private Genre sexe;


@Column(name="NumTel")
@NonNull

private int NumTel;


@Column(name="Adresse")
@NonNull
private String  Adresse;


@Column(name="photo")
@NonNull
private String  photo;


public user(int id, @NonNull String nom, @NonNull String mdp) {
	super();
	this.id = id;
	this.nom = nom;
	this.mdp = mdp;
}


public user() {
	super();
}


public user(int id, @NonNull String nom, @NonNull String mdp, @NonNull String email) {
	super();
	this.id = id;
	this.nom = nom;
	this.mdp = mdp;
	this.email = email;

}


}
