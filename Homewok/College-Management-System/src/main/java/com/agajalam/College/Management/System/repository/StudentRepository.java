package com.agajalam.College.Management.System.repository;

import com.agajalam.College.Management.System.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}