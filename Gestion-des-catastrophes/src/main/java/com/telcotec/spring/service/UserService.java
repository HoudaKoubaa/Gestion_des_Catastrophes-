package com.telcotec.spring.entities;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Setter
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
//@Data
@Table(name="User")
@JsonIgnoreProperties(ignoreUnknown = true)

public class user implements UserDetails {


    @SequenceGenerator(
            name = "User_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private int  id;
  
    private Boolean locked = false;
    private Boolean enabled = false;

	public enum TypeRole {
		Administrateur,DGPC,BNSP,ANAM,DGRE,CONASUR,SAP
	}

	public enum Genre {
		Homme,Femme,autre
	}


	@Column(name="cin")
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
	private TypeRole role;


	@Column(name="email")
	@NonNull
	private String email;


	@Column(name="mdp")
	@NonNull
	private String password;


	@Column(name="dateNaiss")
	private Date DadateNaiss;
	@Enumerated(EnumType.STRING)
	@Column(name="sexe")
	private Genre sexe;


	@Column(name="NumTel")

	private int NumTel;


	@Column(name="Adresse")
	@NonNull
	private String  Adresse;


	@Column(name="photo")
	@NonNull
	private String  photo;


	public user(int id, @NonNull String nom, @NonNull String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.password = password;
	}
	


	public user() {
		super();
	}


	  public user(String firstName,
              String lastName,
              String email,
              String password) {
   this.nom = firstName;
   this.prenom = lastName;
   this.email = email;
   this.password = password;
 
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
   SimpleGrantedAuthority authority =
           new SimpleGrantedAuthority(role.name());
   return Collections.singletonList(authority);
}



@Override
public String getUsername() {
   return email;
}

public String getFirstName() {
   return nom;
}

public String getLastName() {
   return prenom;
}

@Override
public boolean isAccountNonExpired() {
   return true;
}

@Override
public boolean isAccountNonLocked() {
   return !locked;
}

@Override
public boolean isCredentialsNonExpired() {
   return true;
}

@Override
public boolean isEnabled() {
   return enabled;
}



public user(int id, @NonNull String nom, @NonNull String prenom, @NonNull String mdp) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.password = password;
}



public String getEmail() {
	   return email;

}

public String getPassword()
{
	return password;
}


public int getId() {
	return id;
}
}