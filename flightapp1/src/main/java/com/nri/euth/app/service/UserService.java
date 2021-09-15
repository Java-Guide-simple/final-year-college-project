package com.nri.euth.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nri.euth.app.entities.User;
import com.nri.euth.app.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	

	public User registeredNewUser(User user) {
		
		
		User findByEmailId = userRepo.findByEmailId(user.getEmailId());
		if(findByEmailId == null) {
			userRepo.save(user);
			return user;
		}else {
			return null;
		}
		
	}

	public User login(String email ,String password ) {
		
		User findByEmailId = userRepo.findByEmailId(email);
		
		
		if(findByEmailId == null) {
			return null;
		}if(findByEmailId != null && !(findByEmailId.getPassword().equals(password)))  {
			return findByEmailId;
		}else {
			return findByEmailId;
		}
		
	}

}
