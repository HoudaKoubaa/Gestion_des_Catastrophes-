package com.telcotec.spring.service;
import java.util.List;

import com.telcotec.spring.entities.user;

public interface IUserService {
	List<user> retrieveAllUsers();
	user addUser(user p);
	user updateUser(user p);
	user retrieveUser(int id);
	void deleteUser(int id);

}
