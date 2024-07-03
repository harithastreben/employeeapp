package com.employee.attendanceManagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.employee.attendanceManagement.dto.UserRequest;
import com.employee.attendanceManagement.dto.UserResponse;
import com.employee.attendanceManagement.entity.UserEntity;
@Mapper(componentModel="Spring")
public interface UserMapper {

	UserEntity toEntity(UserRequest userRequest);

	UserResponse toResponse(UserEntity user);

	List<UserResponse> toResponseDto(List<UserEntity> byIsDeletedFalse);

	

}
