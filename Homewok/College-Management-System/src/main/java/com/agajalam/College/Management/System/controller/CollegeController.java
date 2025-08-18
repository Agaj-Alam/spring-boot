package com.agajalam.College.Management.System.controller;

import com.agajalam.College.Management.System.dto.StudentDTO;
import com.agajalam.College.Management.System.entities.Student;
import com.agajalam.College.Management.System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/college")
public class CollegeController {

    private final StudentService studentService;

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long studentId){
        Optional<StudentDTO> studentDTO=studentService.getStudentById(studentId);
        return studentDTO
                .map(studentDTO1->ResponseEntity.ok(studentDTO1))
                .orElseThrow();
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
