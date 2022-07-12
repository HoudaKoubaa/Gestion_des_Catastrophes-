package com.telcotec.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcotec.spring.entities.Programme;

@Repository
public interface ProgrammeRepository  extends JpaRepository<Programme,Integer>{

}
