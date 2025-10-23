package com.agajalam.week7.TestingApp.repositories;

import com.agajalam.week7.TestingApp.TestContainerConfiguration;
import com.agajalam.week7.TestingApp.entities.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@Import(TestContainerConfiguration.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp(){
        employee=Employee.builder()
//                .id(1L)
                .name("Agaj")
                .email("agajalam283@gmail.com")
                .salary(100L)
                .build();
    }

    @Test
    void testFindByEmail_whenEmailIsPresent_thenReturnEmployee() {
//        Arrange.  Given
            employeeRepository.save(employee);

//        Act. when
            List<Employee> employeeList=employeeRepository.findByEmail(employee.getEmail());

//        Assert.  Then
            assertThat(employeeList).isNotNull();
            assertThat(employeeList).isNotEmpty();
            assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());

    }


    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList(){
//        Given
        String email="notPresent.123@gmail.com";

//        When
        List<Employee>employeeList=employeeRepository.findByEmail(email);
//        Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isEmpty();
    }
}