package com.agajalam.College.Management.System.controller;

import com.agajalam.College.Management.System.dto.StudentDTO;
import com.agajalam.College.Management.System.entities.Student;
import com.agajalam.College.Management.System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long studentId){
        Optional<StudentDTO> studentDTO=studentService.getStudentById(studentId);
        return studentDTO
                .map(studentDTO1->ResponseEntity.ok(studentDTO1))
                .orElseThrow();
    }

    @GetMapping
    public ResponseEntity<Set<StudentDTO>>getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }



    @PostMapping
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody StudentDTO dto) {
        StudentDTO savedStudent = studentService.createNewStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);

        // postman se bhejne wala data
//        {
//            "name": "Sahil",
//                "professors": [
//            { "id": 1 },
//            { "id": 2 }
//  ],
//            "subjects": [
//            { "id": 3 },
//            { "id": 4 }
//  ],
//            "admissionRecord": {
//            "fees": 20000
//        }
//        }
    }


}
