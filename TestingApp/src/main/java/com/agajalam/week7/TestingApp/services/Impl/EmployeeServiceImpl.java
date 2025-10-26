package com.agajalam.week7.TestingApp.services.Impl;

import com.agajalam.week7.TestingApp.dto.EmployeeDto;
import com.agajalam.week7.TestingApp.entities.Employee;
import com.agajalam.week7.TestingApp.exceptions.ResourceNotFoundExceptions;
import com.agajalam.week7.TestingApp.repositories.EmployeeRepository;
import com.agajalam.week7.TestingApp.services.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    @Override
    public EmployeeDto getEmployeeById(Long id) {
        log.info("fetching employee by id: {}", id);
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->{
                    log.error("Employee not found with id: {}",id);
                    return new ResourceNotFoundExceptions("Employee not found with id: "+id);
                });
        log.info("Successfully fetched employee by id");
        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        log.info("Creating new employee with email: {}",employeeDto.getEmail());
        List<Employee> existingEmployees=employeeRepository.findByEmail(employeeDto.getEmail());
        if(!existingEmployees.isEmpty()){
            log.error("employee already exist with email id: {}",employeeDto.getEmail());
            throw new RuntimeException("employee already exist with email id:"+employeeDto.getEmail());
        }
        Employee newEmployee=modelMapper.map(employeeDto,Employee.class);
        Employee savedEmployee=employeeRepository.save(newEmployee);
        log.info("successfully created new employee with id: {}",savedEmployee.getId());
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        log.info("updating employee with id: {}",id);
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->{
                    log.error("employee not found with id: {}",id);
                    throw new ResourceNotFoundExceptions("employee not found with id: {}"+id);
                });

        if(!employee.getEmail().equals(employeeDto.getEmail())){
            log.info("Attempted ot update employee email with id:{}",id);
            throw new RuntimeException("employee email cannot be updated");
        }

        employeeDto.setId(null);
        modelMapper.map(employeeDto,employee);

        Employee savedEmployee=employeeRepository.save(employee);
        log.info("Successfully updated employee with id: {}",id);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("deleting employee with id: {}",id);
        boolean exists=employeeRepository.existsById(id);
        if(!exists){
            log.error("employee not found with id: {}",id);
            throw new ResourceNotFoundExceptions("employee not found with id: {}"+id);
        }
        employeeRepository.deleteById(id);
        log.info("Employee deleted successfully with id:{}",id);
    }
}
