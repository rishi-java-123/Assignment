package com.db.assignment.ecommerce.service;

import java.util.List;

import com.db.assignment.ecommerce.model.User;

public interface UserService {

	User saveUser(User user);

	User findUserByEmail(String email);

	List<User> findAllUsers();
}