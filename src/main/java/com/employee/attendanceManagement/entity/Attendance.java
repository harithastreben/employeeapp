package com.employee.attendanceManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_attendences")
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "this field can't be empty")
	private String date;

	@NotNull(message = "this field can't be empty")
	private String loginTime;

	private String logoutTime;

	private boolean isDeleted;

	private boolean isPresent;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private UserEntity user;

	@PrePersist
	protected void onPersist() {

		isDeleted = false;
	}
}
