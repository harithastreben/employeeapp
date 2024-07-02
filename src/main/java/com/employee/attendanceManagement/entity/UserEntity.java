package com.employee.attendanceManagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "this field can't be empty")
	private String name;

	@NotNull(message = "this field can't be empty")
	private String dateOfBirth;

	private String address;

	@NotNull(message = "this field can't be empty")
	private String department;

	private boolean isDeleted;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Asset> assets;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Attendance> attendances;

	@PrePersist
	protected void onPersist() {

		isDeleted = false;
	}
}
