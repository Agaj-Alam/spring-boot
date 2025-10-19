package com.agajalam.week7.TestingApp.repositories;

import com.agajalam.week7.TestingApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByEmail(String email);
}
