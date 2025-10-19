package com.agajalam.week7.TestingApp.services;

import com.agajalam.week7.TestingApp.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createNewEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto);
    void deleteEmployee(Long id);

}
