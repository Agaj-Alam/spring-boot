package com.HomeWork.Week2HomeWork.controller;

import com.HomeWork.Week2HomeWork.dto.DepartmentDTO;
import com.HomeWork.Week2HomeWork.exceptions.ResourceNotFoundException;
import com.HomeWork.Week2HomeWork.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable (name = "departmentId")Long id){
        Optional<DepartmentDTO>departmentDTO=departmentService.getDepartmentById(id);
        return departmentDTO
                .map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1))
                .orElseThrow(()->new ResourceNotFoundException("department not found with id : "+id));
    }

    @GetMapping
    public ResponseEntity <List<DepartmentDTO>> getAllDepartment(@RequestParam (required = false)Integer age,
                                                                 @RequestParam (required = false) String sortby){
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO inputDepartment){
        DepartmentDTO savedDepartment=departmentService.createNewDepartment(inputDepartment);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO,@PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentId, departmentDTO));
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean>deleteDepartmentById(@PathVariable Long departmentId){
        boolean gotDeleted= departmentService.deleteDepartmentById(departmentId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updatePartialDepartmentById(@RequestBody Map<String,Object> updates,
                                                                     @PathVariable Long departmentId){
        DepartmentDTO departmentDTO=departmentService.updatePartialDepartmentById(departmentId,updates);
        if(departmentDTO==null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDTO);

    }









}
