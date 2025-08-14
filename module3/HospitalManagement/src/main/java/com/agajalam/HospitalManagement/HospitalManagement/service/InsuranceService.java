package com.agajalam.HospitalManagement.HospitalManagement.service;

import com.agajalam.HospitalManagement.HospitalManagement.entities.Insurance;
import com.agajalam.HospitalManagement.HospitalManagement.entities.Patient;
import com.agajalam.HospitalManagement.HospitalManagement.repository.InsuranceRepository;
import com.agajalam.HospitalManagement.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance asignInsuranceToPatient(Insurance insurance,Long patientId){
        Patient patient=patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance); //dirty patient

        insurance.setPatient(patient); // optional (for bidirectional mapping)

        return insurance;
    }


}
