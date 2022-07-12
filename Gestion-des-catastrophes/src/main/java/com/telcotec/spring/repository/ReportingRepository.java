package com.telcotec.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telcotec.spring.entities.Reporting;

public interface ReportingRepository  extends JpaRepository<Reporting,Integer>{

}
