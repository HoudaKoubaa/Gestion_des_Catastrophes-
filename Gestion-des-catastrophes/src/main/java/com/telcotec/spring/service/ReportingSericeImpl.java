package com.telcotec.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telcotec.spring.entities.Programme;
import com.telcotec.spring.entities.Reporting;
import com.telcotec.spring.repository.ReportingRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReportingSericeImpl implements IReportingService{
	
	@Autowired
	ReportingRepository reportingRepository;
	
	@Override
	public List<Reporting> retrieveAllReports() {
		List<Reporting> reportingList =  reportingRepository.findAll();
		for (Reporting reporting : reportingList){
			log.info(" Reporting: " +reporting);
		}
		return reportingList;
	}

	@Override
	public Reporting addReport(Reporting r) {
		reportingRepository.save(r);
		return r;
	}

	@Override
	public Reporting updateReport(Reporting r) {
		reportingRepository.save(r);
		return r;
	}

	@Override
	public Reporting retrieveReport(int id) {
		return reportingRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteReport(int id) {
		reportingRepository.deleteById(id);
		
	}

}
