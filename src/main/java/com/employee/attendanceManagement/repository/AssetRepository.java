package com.employee.attendanceManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.attendanceManagement.entity.Asset;
@Repository
public interface AssetRepository extends JpaRepository<Asset,Long> {

}
