package com.employee.attendanceManagement.dto;

import com.employee.attendanceManagement.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceRequest {
	private Long id;

	private String date;

	private String loginTime;

	private String logoutTime;

	private boolean isPresent;

	private UserEntity user;
}
