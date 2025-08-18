package com.agajalam.College.Management.System.dto;

import com.agajalam.College.Management.System.entities.AdmissionRecord;
import com.agajalam.College.Management.System.entities.Professor;
import com.agajalam.College.Management.System.entities.Student;
import com.agajalam.College.Management.System.entities.Subject;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubjectDTO {
    private Long id;

    private String title;

    private Professor professor;

    private List<String> students=new ArrayList<>();
}
