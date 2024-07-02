package com.employee.attendanceManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	
    private Long id;
    
    private String name;

    private String dateOfBirth;

    private String address;

    private String department;


}
