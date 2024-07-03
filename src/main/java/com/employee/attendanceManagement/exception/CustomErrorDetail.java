package com.employee.attendanceManagement.exception;

import java.util.Date;

import lombok.Data;
@Data

public class CustomErrorDetail {

	private Date timestamp;
	private Integer errorcode;
	private String message;
	public CustomErrorDetail(Date timestamp, Integer errorcode, String message) {
		super();
		this.timestamp = timestamp;
		this.errorcode = errorcode;
		this.message = message;
	}
	

}
