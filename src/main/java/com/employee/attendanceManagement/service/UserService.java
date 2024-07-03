package com.employee.attendanceManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.attendanceManagement.dto.UserRequest;
import com.employee.attendanceManagement.dto.UserResponse;
import com.employee.attendanceManagement.entity.UserEntity;
import com.employee.attendanceManagement.exception.UserNotFoundException;
import com.employee.attendanceManagement.mapper.UserMapper;
import com.employee.attendanceManagement.repository.UserRepository;




@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;


    public UserResponse createUser(UserRequest userRequest) {
        UserEntity user = userMapper.toEntity(userRequest);
        userRepo.save(user);
        return userMapper.toResponse(user);
    }

    public List<UserResponse> listAllUser() {
        return userMapper.toResponseDto(userRepo.findByIsDeletedFalse());
    }

    public UserResponse getUserById(Long id) throws UserNotFoundException {
        Optional<UserEntity> userOptional = userRepo.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User not found with id: " + id);
        }
        UserEntity user = userOptional.get();
        return userMapper.toResponse(user);
    }


    public UserResponse updateUser(Long id, UserRequest userRequest) throws UserNotFoundException {
        Optional<UserEntity> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity existingUser = optionalUser.get();
            // Update only the fields that are allowed to be updated
            if (userRequest.getName() != null) {
                existingUser.setName(userRequest.getName());
            }
            if (userRequest.getDateOfBirth() != null) {
                existingUser.setDateOfBirth(userRequest.getDateOfBirth());
            }
            if (userRequest.getAddress() != null) {
                existingUser.setAddress(userRequest.getAddress());
            }
            if (userRequest.getDepartment() != null) {
                existingUser.setDepartment(userRequest.getDepartment());
            }
            // Save the updated entity
            UserEntity updatedUser = userRepo.save(existingUser);
            return userMapper.toResponse(updatedUser);
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }


    public void deleteUser(Long id) throws UserNotFoundException {
        Optional<UserEntity> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            user.setDeleted(true); // Set the isDeleted flag to true
            userRepo.save(user);
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }
}

