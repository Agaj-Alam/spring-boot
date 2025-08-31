package com.agajalam.prod_ready_features.clients.impl;

import com.agajalam.prod_ready_features.advice.ApiResponse;
import com.agajalam.prod_ready_features.clients.EmployeeClient;
import com.agajalam.prod_ready_features.dto.EmployeeDTO;
import com.agajalam.prod_ready_features.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
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


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try{
            ApiResponse<List<EmployeeDTO>> employeeDTOList=restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOList.getData();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        try{
            ApiResponse<EmployeeDTO>employeeResponse=restClient.get()
                    .uri("employees/{employeeId}", employeeId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeResponse.getData();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        try{
            ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTOApiResponse=restClient.post()
                    .uri("employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                        System.out.println(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOApiResponse.getBody().getData();
        }
        catch (Exception e){
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
