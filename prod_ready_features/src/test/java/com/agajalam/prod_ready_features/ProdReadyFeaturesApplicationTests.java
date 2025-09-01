package com.agajalam.prod_ready_features;

import com.agajalam.prod_ready_features.clients.EmployeeClient;
import com.agajalam.prod_ready_features.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProdReadyFeaturesApplicationTests {

    @Autowired
    private EmployeeClient employeeClient;


	@Test
    @Order(3)
	void getAllEmployees(){
        List<EmployeeDTO> employeeDTOList=employeeClient.getAllEmployees();
        System.out.println(employeeDTOList);
    }

    @Test
    @Order(2)
    void getEmployeeByIdTest(){
        EmployeeDTO employeeDTO=employeeClient.getEmployeeById(1L);
        System.out.println(employeeDTO);
    }
    @Test
    @Order(1)
    void createNewEmployee(){
        EmployeeDTO employeeDTO=new EmployeeDTO(null,"sahil","sahil@gmail.com",2,"USER",400.00,
                LocalDate.of(2025,12,1),
                true,2,2);
        EmployeeDTO savedEmployeeDTO=employeeClient.createNewEmployee(employeeDTO);
        System.out.println(savedEmployeeDTO);
    }
//
//    @Test
//    void updateEmployeeById(){
//        EmployeeDTO employeeDTO=new EmployeeDTO(null,"Agaj","agaj@gmail.com",22,"USER",2000.00,
//                LocalDate.of(2025,12,1),
//                true,2,2);
//        EmployeeDTO savedEmployeeDTO=employeeClient.updateEmployeeById(employeeDTO,1L);
//        System.out.println(savedEmployeeDTO);
//    }
//
//    @Test
//    void deleteEmployeeById(){
//        Boolean result=employeeClient.deleteEmployeeById(1L);
//        System.out.println(result);
//    }
}
