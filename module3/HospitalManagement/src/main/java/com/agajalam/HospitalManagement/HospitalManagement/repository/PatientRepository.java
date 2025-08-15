package com.agajalam.HospitalManagement.HospitalManagement.repository;

import com.agajalam.HospitalManagement.HospitalManagement.dto.BloodGroupStats;
import com.agajalam.HospitalManagement.HospitalManagement.dto.CPatientInfo;
import com.agajalam.HospitalManagement.HospitalManagement.dto.IPatientInfo;
import com.agajalam.HospitalManagement.HospitalManagement.entities.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query("select p.name as name,p.id as id,p.email as email from Patient p")
    List<IPatientInfo> getAllPatientInfo();

    @Query("select new com.agajalam.HospitalManagement.HospitalManagement.dto.CPatientInfo(p.id,p.name) " + "from Patient p")
    List<CPatientInfo>getAllPatientsInfoConcrete();

    @Query("select new com.agajalam.HospitalManagement.HospitalManagement.dto.BloodGroupStats(p.bloodGroup, " +
            "COUNT(p))from Patient p group by p.bloodGroup  order by COUNT(p)")
    List<BloodGroupStats> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p set p.name= :name where p.id= :id")
    int updatePatientNameWithId(@Param("name") String name,@Param("id") Long id);


    @Query("select p from Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> getAllPatientsWithAppointment();
}
