package com.telcotec.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "localisation")
public class localisation implements Serializable{
	@Id
private int id;
}
