package com.agajalam.HospitalManagement.HospitalManagement;

import com.agajalam.HospitalManagement.HospitalManagement.entities.Appointment;
import com.agajalam.HospitalManagement.HospitalManagement.entities.Insurance;
import com.agajalam.HospitalManagement.HospitalManagement.service.AppointmentService;
import com.agajalam.HospitalManagement.HospitalManagement.service.InsuranceService;
import com.agajalam.HospitalManagement.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

  @Test
    public void testAssignInsuranceToPatient(){
      Insurance insurance=Insurance.builder()
              .provider("HDFC")
              .policyNumber("HDFC123")
              .validUntil(LocalDate.of(2030,05,06))
              .build();
      var updatedInsurance=insuranceService.asignInsuranceToPatient(insurance,1L);
      System.out.println(updatedInsurance);

      patientService.deletePatient(1L);
  }

  @Test
  public void testCreateANewAppointment(){
      Appointment appointment=Appointment.builder()
              .appointmentTime(LocalDateTime.of(2025,8,20,14,0,0))
              .reason("headache")
              .build();

      var createdANewAppointment=appointmentService.createANewAppointment(appointment,1L,2L );
      System.out.println(createdANewAppointment);


      patientService.deletePatient(1L);
  }
}
