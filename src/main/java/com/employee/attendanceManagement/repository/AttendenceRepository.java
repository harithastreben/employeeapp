package com.employee.attendanceManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.attendanceManagement.entity.Attendance;
@Repository
public interface AttendenceRepository extends JpaRepository<Attendance,Long> {

}
