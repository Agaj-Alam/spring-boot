package com.agajalam.HospitalManagement.HospitalManagement.repository;

import com.agajalam.HospitalManagement.HospitalManagement.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}