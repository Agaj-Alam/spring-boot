package com.agajalam.College.Management.System.dto;

import com.agajalam.College.Management.System.entities.Student;
import com.agajalam.College.Management.System.entities.Subject;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class ProfessorDTO {


    private Long id;
    private String title;

//    @JsonIgnore
    private Set<SubjectSummaryDTO> subjects;

//    @JsonIgnore
    private Set<StudentSummaryDTO> students;

}
