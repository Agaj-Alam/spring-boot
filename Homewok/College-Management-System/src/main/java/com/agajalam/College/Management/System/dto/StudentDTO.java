package com.agajalam.College.Management.System.dto;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class StudentDTO {
    private Long id;
    private String name;

//    @JsonIgnore
    private Set<ProfessorSummaryDTO> professors;

//    @JsonIgnore
    private Set<SubjectSummaryDTO> subjects;

//    @JsonIgnore
    private AdmissionRecordSummaryDTO admissionRecord;

}
