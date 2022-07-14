package com.telcotec.spring.repository;
import com.telcotec.spring.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<user,Integer> {

	
	user findByNom(String username);
}
