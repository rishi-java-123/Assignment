package com.db.assignment.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.assignment.ecommerce.dtos.Response;
import com.db.assignment.ecommerce.dtos.ResponseTypeEnum;
import com.db.assignment.ecommerce.model.User;
import com.db.assignment.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/add")
	public Response<?> addNewUser(@RequestBody User user) {

		try {
			return new Response<User>(ResponseTypeEnum.SUCCESS, userService.saveUser(user));
		} catch (Exception e) {
			return new Response<String>(ResponseTypeEnum.ERROR, e.getMessage());
		}
	}
}
