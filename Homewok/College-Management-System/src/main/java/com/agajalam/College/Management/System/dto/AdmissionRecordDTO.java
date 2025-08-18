package com.agajalam.College.Management.System.dto;

import com.agajalam.College.Management.System.entities.Student;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class AdmissionRecordDTO {

    private Long id;

    private Integer fees;

    private Student student;

}
