package com.telcotec.spring.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telcotec.spring.entities.Intervention;
import com.telcotec.spring.service.IInterventionService;




@RestController
public class InterventionController {
	
	@Autowired
	IInterventionService iinterventionService;

	
	@PostMapping("/add-intervention")
	Intervention addIntervention(@RequestBody Intervention i){
		return iinterventionService.addIntervention(i);
	}
	
	
	@GetMapping("/retrieve-all-interventions")
	List<Intervention> retrieveAllInterventions(){
		
		return iinterventionService.retrieveAllInterventions();
	}
	@PutMapping("modify-intervention")
	Intervention updateIntervention(@RequestBody Intervention e){
		
		return iinterventionService.updateIntervention(e);
	}
	
	@DeleteMapping("delete-Intervention/{id}")
	void deleteIntervention(@PathVariable("id") int idIntervention){
		iinterventionService.deleteIntervention(idIntervention);
		
	}
	
	@GetMapping("/get-Intervention/{idIntervention}")
	Intervention getInterventionById(@PathVariable("idIntervention") int idIntervention){
		return iinterventionService.retrieveIntervention(idIntervention);
		
	}
}
