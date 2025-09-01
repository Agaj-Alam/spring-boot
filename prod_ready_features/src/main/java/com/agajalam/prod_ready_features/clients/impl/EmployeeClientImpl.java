package com.agajalam.prod_ready_features.clients.impl;

import com.agajalam.prod_ready_features.advice.ApiResponse;
import com.agajalam.prod_ready_features.clients.EmployeeClient;
import com.agajalam.prod_ready_features.dto.EmployeeDTO;
import com.agajalam.prod_ready_features.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log= LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        log.trace("trying to retrieve all employees in getAllEmployees");
        try{
            log.info("attempting to call restClient in getAllEmployees");
            ApiResponse<List<EmployeeDTO>> employeeDTOList=restClient.get()
                    .uri("employees")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not found the employees");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.debug("Successfully retrieved the employees in getAllEmployees");
            log.trace("Retrieved all employees list in getAllEmployees: {},{},{}",employeeDTOList.getData(),"hello",5);
            return employeeDTOList.getData();
        }catch (Exception e){
            log.error("Exception occurred in getAllEmployees");
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        log.trace("trying to get employee by Id in getEmployeeBYId with Id : {}",employeeId);
        try{
            ApiResponse<EmployeeDTO>employeeResponse=restClient.get()
                    .uri("employees/{employeeId}", employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not found  employee by id ");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeResponse.getData();
        }catch (Exception e){
            log.error("Exception occurred in getEmployeeById ",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        log.trace("trying to create employee with information  : {}",employeeDTO);

        try{
            ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTOApiResponse=restClient.post()
                    .uri("employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        log.trace("4xx error occurred in createNewEmployee");
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .toEntity(new ParameterizedTypeReference<>() {
                    });
            log.trace("Successfully created a new employee :{}",employeeDTOApiResponse.getBody());
            return employeeDTOApiResponse.getBody().getData();
        }
        catch (Exception e){
            log.error("Exception occurred in create Employee",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Long employeeId) {
        try{
            ApiResponse<EmployeeDTO>employeeDTOApiResponseUpdate=restClient.put()
                    .uri("employees/{employeeId}",employeeId)
                    .body(employeeDTO)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOApiResponseUpdate.getData();
        } catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteEmployeeById(Long employeeId) {
        try{
            ApiResponse<Boolean>employeeDTOApiResponseDelete=restClient.delete()
                    .uri("employees/{employeeId}",employeeId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return true;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
