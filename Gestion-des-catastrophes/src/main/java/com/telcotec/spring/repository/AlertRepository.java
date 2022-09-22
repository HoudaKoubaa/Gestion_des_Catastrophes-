package com.telcotec.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcotec.spring.entities.Alert;
@Repository
public interface AlertRepository extends JpaRepository<Alert,Integer> {

}
