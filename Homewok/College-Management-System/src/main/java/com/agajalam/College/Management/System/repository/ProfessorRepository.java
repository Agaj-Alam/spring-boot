package com.agajalam.College.Management.System.repository;

import com.agajalam.College.Management.System.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}