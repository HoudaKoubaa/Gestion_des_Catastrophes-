package com.telcotec.spring.service;

import java.util.List;

import com.telcotec.spring.entities.Reporting;

public interface IReportingService {
	List<Reporting> retrieveAllReports();
	Reporting addReport(Reporting r);
	Reporting updateReport(Reporting r);
	Reporting retrieveReport(int id);
	void deleteReport(int id);

}
