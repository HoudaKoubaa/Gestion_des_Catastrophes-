package com.telcotec.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telcotec.spring.entities.Programme;
import com.telcotec.spring.repository.ProgrammeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProgrammeServiceImpl implements IProgrammeService{
	
	@Autowired
	ProgrammeRepository programmeRepository;
	
	@Override
	public List<Programme> retrieveAllProgrammes() {
		List<Programme> programmeList =  programmeRepository.findAll();
	/*	for (Programme programme : programmeList){
			log.info(" Programme: " +programme);
		}*/
		return programmeList;
	}

	@Override
	public Programme addProgramme(Programme p) {
		programmeRepository.save(p);
		return p;
	}

	@Override
	public Programme updateProgramme(Programme p) {
		programmeRepository.save(p);
		return p;
	}

	@Override
	public Programme retrieveProgramme(int id) {
		return programmeRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteProgramme(int id) {
		programmeRepository.deleteById(id);
		
	}

}
