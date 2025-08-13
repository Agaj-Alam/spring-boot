package com.agajalam.HospitalManagement.HospitalManagement;

import com.agajalam.HospitalManagement.HospitalManagement.dto.BloodGroupStats;
import com.agajalam.HospitalManagement.HospitalManagement.dto.CPatientInfo;
import com.agajalam.HospitalManagement.HospitalManagement.dto.IPatientInfo;
import com.agajalam.HospitalManagement.HospitalManagement.repository.PatientRepository;
import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientRepository patientRepository;

//    @Test
//    public void testPatient(){
//        List<IPatientInfo> patientList=patientRepository.getAllPatientInfo();
//
//        for(IPatientInfo p:patientList){
//            System.out.println(p);
//        }
//    }

    @Test
    public void testPatient(){
//        List<CPatientInfo> patientList=patientRepository.getAllPatientsInfoConcrete();
//        List<BloodGroupStats> patientList=patientRepository.getBloodGroupStats();
//
//        for(var p:patientList){
//            System.out.println(p);
//        }

    int rowsAffected=patientRepository.updatePatientNameWithId("Raushan kumar teli",1L);
        System.out.println(rowsAffected);
    }

}
