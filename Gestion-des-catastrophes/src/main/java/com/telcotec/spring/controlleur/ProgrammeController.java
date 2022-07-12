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
import com.telcotec.spring.entities.Programme;
import com.telcotec.spring.service.IProgrammeService;

@RestController
public class ProgrammeController {
	
	@Autowired
	IProgrammeService programmeService;

	
	@PostMapping("/add-programme")
	Programme addProgramme(@RequestBody Programme p){
		return programmeService.addProgramme(p);
	}
	
	
	@GetMapping("/retrieve-all-programmes")
	List<Programme> retrieveAllProgrammes(){
		
		return programmeService.retrieveAllProgrammes();
	}
	@PutMapping("modify-programme")
	Programme updateIntervention(@RequestBody Programme p){
		
		return programmeService.updateProgramme(p);
	}
	
	@DeleteMapping("delete-programme/{id}")
	void deleteProgramme(@PathVariable("id") int idProgramme){
		programmeService.deleteProgramme(idProgramme);	
	}
	
	@GetMapping("/get-programme/{idProgramme}")
	Programme getProgrammeById(@PathVariable("idProgramme") int idProgramme){
		return programmeService.retrieveProgramme(idProgramme);
		
	}

}
