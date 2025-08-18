package com.agajalam.College.Management.System.service;

import com.agajalam.College.Management.System.dto.StudentDTO;
import com.agajalam.College.Management.System.entities.Student;
import com.agajalam.College.Management.System.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public Optional<StudentDTO> getStudentById(Long studentId){
        return studentRepository.findById(studentId).map(student->modelMapper.map(student,StudentDTO.class));
    }

    public List<StudentDTO> getAllStudents(){
//        List<Student> students=studentRepository.findAll();
        return  studentRepository.findAll()
                .stream()
                .map(student -> modelMapper.map(student,StudentDTO.class))
                .collect(Collectors.toList());
    }
}
