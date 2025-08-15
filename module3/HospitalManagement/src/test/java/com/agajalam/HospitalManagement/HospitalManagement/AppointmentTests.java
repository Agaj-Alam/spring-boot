package com.agajalam.HospitalManagement.HospitalManagement;

import com.agajalam.HospitalManagement.HospitalManagement.entities.Appointment;
import com.agajalam.HospitalManagement.HospitalManagement.repository.DoctorRepository;
import com.agajalam.HospitalManagement.HospitalManagement.repository.PatientRepository;
import com.agajalam.HospitalManagement.HospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateANewAppointment(){
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,8,20,14,0,0))
                .reason("headache")
                .build();

        var createdANewAppointment=appointmentService.createANewAppointment(appointment,1L,4L );
        System.out.println(createdANewAppointment);


//      patientService.deletePatient(1L);
    }

}
