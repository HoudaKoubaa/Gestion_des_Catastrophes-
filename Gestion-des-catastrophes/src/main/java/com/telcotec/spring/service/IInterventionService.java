package com.telcotec.spring.service;

import java.util.List;

import com.telcotec.spring.entities.Intervention;

public interface IInterventionService {

	List<Intervention> retrieveAllInterventions();
	Intervention addIntervention(Intervention i);
	Intervention updateIntervention(Intervention i);
	Intervention retrieveIntervention(int id);
	void deleteIntervention(int id);
}
