package com.agajalam.HospitalManagement.HospitalManagement.repository;

import com.agajalam.HospitalManagement.HospitalManagement.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}