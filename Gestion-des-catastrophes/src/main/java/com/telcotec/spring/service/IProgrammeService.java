package com.telcotec.spring.service;

import java.util.List;

import com.telcotec.spring.entities.Programme;


public interface IProgrammeService {
	List<Programme> retrieveAllProgrammes();
	Programme addProgramme(Programme p);
	Programme updateProgramme(Programme p);
	Programme retrieveProgramme(int id);
	void deleteProgramme(int id);
}
