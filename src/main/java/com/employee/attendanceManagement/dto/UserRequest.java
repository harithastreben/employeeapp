package com.employee.attendanceManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UserRequest {
    private String name;

    private String dateOfBirth;

    private String address;

    private String department;



    
   
}
