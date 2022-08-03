package com.telcotec.spring.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telcotec.spring.entities.Reporting;
import com.telcotec.spring.service.IReportingService;

@CrossOrigin(origins = "*")
@RestController
public class ReportingController {
	
	@Autowired
	IReportingService reportingService;
	

	@PostMapping("/add-reporting")
	Reporting addReporting(@RequestBody Reporting r){
		return reportingService.addReport(r);
	}
	
	
	@GetMapping("/retrieve-all-reports")
	List<Reporting> retrieveAllReports(){
		
		return reportingService.retrieveAllReports();
	}
	@PutMapping("modify-report")
	Reporting updateReporting(@RequestBody Reporting r){
		
		return reportingService.updateReport(r);
	}
	
	@DeleteMapping("delete-report/{id}")
	void deleteReporting(@PathVariable("id") int idReport){
		reportingService.deleteReport(idReport);
		
	}
	
	@GetMapping("/get-report/{idReport}")
	Reporting getReportById(@PathVariable("idReport") int idReport){
		return reportingService.retrieveReport(idReport);
		
	}

}
