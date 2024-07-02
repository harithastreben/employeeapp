package com.employee.attendanceManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.attendanceManagement.dto.UserRequest;
import com.employee.attendanceManagement.dto.UserResponse;
import com.employee.attendanceManagement.service.UserService;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
@Autowired
	private UserService userService;

//create user
@PostMapping()
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
		return new ResponseEntity<>(userService.createUser(userRequest),HttpStatus.CREATED);
	}
	
//	get all users
	@GetMapping()
	public ResponseEntity<List<UserResponse>> getAllUser(){
		return new ResponseEntity<>(userService.listAllUser(),HttpStatus.OK);
	}
}
