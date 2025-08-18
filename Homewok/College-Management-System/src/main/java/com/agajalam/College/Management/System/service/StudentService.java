package com.agajalam.College.Management.System.service;

import com.agajalam.College.Management.System.dto.ProfessorSummaryDTO;
import com.agajalam.College.Management.System.dto.StudentDTO;
import com.agajalam.College.Management.System.entities.AdmissionRecord;
import com.agajalam.College.Management.System.entities.Professor;
import com.agajalam.College.Management.System.entities.Student;
import com.agajalam.College.Management.System.entities.Subject;
import com.agajalam.College.Management.System.repository.AdmissionRecordRepository;
import com.agajalam.College.Management.System.repository.ProfessorRepository;
import com.agajalam.College.Management.System.repository.StudentRepository;
import com.agajalam.College.Management.System.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final ProfessorRepository professorRepository;
    private  final SubjectRepository subjectRepository;
    private final AdmissionRecordRepository admissionRecordRepository;

    public Optional<StudentDTO> getStudentById(Long studentId){
        return studentRepository.findById(studentId).map(student->modelMapper.map(student,StudentDTO.class));
    }

    public Set<StudentDTO> getAllStudents(){
//        List<Student> students=studentRepository.findAll();
        return  studentRepository.findAll()
                .stream()
                .map(student -> modelMapper.map(student,StudentDTO.class))
                .collect(Collectors.toSet());
    }

    public StudentDTO createNewStudent(StudentDTO dto){
        Student student=new Student();
        student.setName(dto.getName());

        // 🔹 Professors ko set me convert karke assign karo
        if (dto.getProfessors() != null && !dto.getProfessors().isEmpty()) {
            Set<Professor> professors = dto.getProfessors().stream()
                    .map(profDto -> professorRepository.findById(profDto.getId())
                            .orElseThrow(() -> new RuntimeException("Professor not found: " + profDto.getId())))
                    .collect(Collectors.toSet());
            student.setProfessors(professors);
        }

        // 🔹 Subjects ko set me convert karke assign karo
        if (dto.getSubjects() != null && !dto.getSubjects().isEmpty()) {
            Set<Subject> subjects = dto.getSubjects().stream()
                    .map(subDto -> subjectRepository.findById(subDto.getId())
                            .orElseThrow(() -> new RuntimeException("Subject not found: " + subDto.getId())))
                    .collect(Collectors.toSet());
            student.setSubjects(subjects);
        }
//
//        if (dto.getAdmissionRecord() != null) {
//            AdmissionRecord newRecord = new AdmissionRecord();
//            newRecord.setFees(dto.getAdmissionRecord().getFees());
//            student.setAdmissionRecord(newRecord);
//        }

        if (dto.getAdmissionRecord() != null) {
            AdmissionRecord newRecord = new AdmissionRecord();
            newRecord.setFees(dto.getAdmissionRecord().getFees());

            // dono taraf link set karo
            newRecord.setStudent(student);
            student.setAdmissionRecord(newRecord);
        }

        Student savedStudentEntity=studentRepository.save(student);
        return modelMapper.map(savedStudentEntity,StudentDTO.class);
    }

}
