package com.agajalam.week7.TestingApp.controllers;

import com.agajalam.week7.TestingApp.TestContainerConfiguration;
import com.agajalam.week7.TestingApp.dto.EmployeeDto;
import com.agajalam.week7.TestingApp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient(timeout = "100000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestContainerConfiguration.class)
public class AbstractIntegrationTest {

    @Autowired
     WebTestClient webTestClient;

    Employee testEmployee=Employee.builder()
//                .id(1L)
            .email("agajalam@gmail.com")
                .name("Agaj Alam")
                .salary(200L)
                .build();

    EmployeeDto testEmployeeDto=EmployeeDto.builder()
//                .id(1L)
            .email("agajalam@gmail.com")
                .name("Agaj Alam")
                .salary(200L)
                .build();
}
