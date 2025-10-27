package com.agajalam.week7.TestingApp.controllers;

import com.agajalam.week7.TestingApp.TestContainerConfiguration;
import com.agajalam.week7.TestingApp.dto.EmployeeDto;
import com.agajalam.week7.TestingApp.entities.Employee;
import com.agajalam.week7.TestingApp.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureWebTestClient(timeout = "100000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestContainerConfiguration.class)
class EmployeeControllerTestIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee testEmployee;

    private EmployeeDto testEmployeeDto;

    @BeforeEach
    void setUp(){
        testEmployee=Employee.builder()
//                .id(1L)
                .email("agajalam@gmail.com")
                .name("Agaj Alam")
                .salary(200L)
                .build();

        testEmployeeDto=EmployeeDto.builder()
//                .id(1L)
                .email("agajalam@gmail.com")
                .name("Agaj Alam")
                .salary(200L)
                .build();

    }

    @Test
    void testGetEmployee_success(){
        Employee savedEmployee=employeeRepository.save(testEmployee);
        testEmployeeDto.setId(savedEmployee.getId());  // by adding this from chatgpt
        webTestClient.get()
                .uri("/employees/{id}",savedEmployee.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(EmployeeDto.class)
                .isEqualTo(testEmployeeDto);
//                .value(employeeDto -> {
//                    assertThat(employeeDto.getEmail()).isEqualTo(savedEmployee.getEmail());
//                    assertThat(employeeDto.getId()).isEqualTo(savedEmployee.getId());
//                });

    }

}