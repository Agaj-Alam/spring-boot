package com.agajalam.HospitalManagement.HospitalManagement.service;

import com.agajalam.HospitalManagement.HospitalManagement.entities.Appointment;
import com.agajalam.HospitalManagement.HospitalManagement.entities.Doctor;
import com.agajalam.HospitalManagement.HospitalManagement.entities.Patient;
import com.agajalam.HospitalManagement.HospitalManagement.repository.AppointmentRepository;
import com.agajalam.HospitalManagement.HospitalManagement.repository.DoctorRepository;
import com.agajalam.HospitalManagement.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createANewAppointment(Appointment appointment,Long patientId,Long doctorId){
        Patient patient=patientRepository.findById(patientId).orElseThrow();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }
}
