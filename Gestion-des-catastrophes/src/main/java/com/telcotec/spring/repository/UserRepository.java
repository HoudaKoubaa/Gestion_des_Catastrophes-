package com.telcotec.spring.repository;
import com.telcotec.spring.entities.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface UserRepository extends JpaRepository<user,Integer> {

	
	user findByNom(String username);
	 Optional<user> findByEmail(String email);

	    @Transactional
	    @Modifying
	    @Query("UPDATE user a " +
	            "SET a.enabled = TRUE WHERE a.email = ?1")
	    int enableAppUser(String email);
		user findByUserId(long id);

}
