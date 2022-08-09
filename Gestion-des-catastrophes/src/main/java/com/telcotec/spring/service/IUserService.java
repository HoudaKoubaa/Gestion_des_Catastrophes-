package com.telcotec.spring.service;
import java.util.List;

import com.telcotec.spring.entities.user;

public interface IUserService {

	user updateUser(user u);

	user addUser(user u);


	void deleteUser(int id);

	List<user> retrieveAllUsers();
	

}
