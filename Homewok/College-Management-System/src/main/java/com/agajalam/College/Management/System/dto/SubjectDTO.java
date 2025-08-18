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
public class SubjectDTO {
    private Long id;
    private String title;

//    @JsonIgnore
    private ProfessorSummaryDTO professors;

//    @JsonIgnore
    private Set<StudentSummaryDTO> students;
}
