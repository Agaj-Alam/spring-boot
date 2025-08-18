package com.agajalam.College.Management.System.dto;

import com.agajalam.College.Management.System.entities.Student;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class AdmissionRecordDTO {

    private Long id;

    private Integer fees;

//    @JsonIgnore
    private StudentSummaryDTO student;

}
