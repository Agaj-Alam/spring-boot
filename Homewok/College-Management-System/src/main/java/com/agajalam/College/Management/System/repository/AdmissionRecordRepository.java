package com.agajalam.College.Management.System.repository;

import com.agajalam.College.Management.System.entities.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecord, Long> {
}