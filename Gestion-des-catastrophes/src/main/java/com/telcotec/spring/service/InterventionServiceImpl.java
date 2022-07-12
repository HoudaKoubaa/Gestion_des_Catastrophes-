package com.telcotec.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telcotec.spring.entities.Intervention;
import com.telcotec.spring.repository.InterventionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InterventionServiceImpl implements IInterventionService {
	
	@Autowired
	InterventionRepository interventionRepository;

	@Override
	public List<Intervention> retrieveAllInterventions() {
		List<Intervention> interventionList =  interventionRepository.findAll();
		for (Intervention intervention : interventionList){
			log.info(" Intervention: " +intervention);
		}
		return interventionList;
	}

	@Override
	public Intervention addIntervention(Intervention i) {
		interventionRepository.save(i);
		return i;
	}

	@Override
	public Intervention updateIntervention(Intervention i) {
		interventionRepository.save(i);
		return i;
	}

	@Override
	public Intervention retrieveIntervention(int id) {
		return interventionRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteIntervention(int id) {
		interventionRepository.deleteById(id);
		
	}
	
}
