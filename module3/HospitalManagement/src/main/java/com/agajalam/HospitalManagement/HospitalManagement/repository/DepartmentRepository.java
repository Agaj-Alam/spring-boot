package com.agajalam.HospitalManagement.HospitalManagement.repository;

import com.agajalam.HospitalManagement.HospitalManagement.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}