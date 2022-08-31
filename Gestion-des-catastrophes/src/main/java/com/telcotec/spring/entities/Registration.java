package com.telcotec.spring.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Registration{
    private final String nom;
    private final String prenom;
    private final String email;
    private final String password;
    private final int cin;

}