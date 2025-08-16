package com.agajalam.College.Management.System.repository;

import com.agajalam.College.Management.System.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}