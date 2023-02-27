package com.db.assignment.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.assignment.ecommerce.model.User;
import com.db.assignment.ecommerce.repository.UserRepository;
import com.db.assignment.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
	return userRepository.save(user);
		
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findAllUsers() {
		 List<User> users = userRepository.findAll();
		 return users;
	}
	
	

}
