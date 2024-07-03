package com.employee.attendanceManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetResponse {
	  private Long id;

	    private String name;

	    private String collectedDate;

	    private String returnDate;

	    private Boolean approval;




}
