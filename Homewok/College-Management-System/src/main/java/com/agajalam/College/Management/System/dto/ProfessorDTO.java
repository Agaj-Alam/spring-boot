package com.agajalam.College.Management.System.dto;

import com.agajalam.College.Management.System.entities.Student;
import com.agajalam.College.Management.System.entities.Subject;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProfessorDTO {


    private Long id;

    private String title;


    private List<String> students =new ArrayList<>();

    private List<String>subjects=new ArrayList<>();
}
