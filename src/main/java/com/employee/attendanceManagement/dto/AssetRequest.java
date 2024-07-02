package com.employee.attendanceManagement.dto;

import com.employee.attendanceManagement.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetRequest {


	    private String name;

	    private String collectedDate;

	    private String returnDate;

	    private boolean approval;

	    private UserEntity user;

}
