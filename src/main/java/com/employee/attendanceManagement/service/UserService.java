package com.employee.attendanceManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.attendanceManagement.dto.UserRequest;
import com.employee.attendanceManagement.dto.UserResponse;
import com.employee.attendanceManagement.entity.UserEntity;
import com.employee.attendanceManagement.mapper.UserMapper;
import com.employee.attendanceManagement.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserMapper userMapper;
	

//  create User  
	
    public UserResponse createUser(UserRequest userRequest) {
    	UserEntity user=userMapper.toEntity(userRequest);
    	userRepo.save(user);
    	return userMapper.toResponse(user);
    }
    
//  list all user  
    
    public List<UserResponse> listAllUser() {
    	return userMapper.toResponseDto(userRepo.findByIsDeletedFalse());
    }
    	
    

}
