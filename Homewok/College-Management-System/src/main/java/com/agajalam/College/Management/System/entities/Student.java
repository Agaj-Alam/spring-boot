package com.agajalam.College.Management.System.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    private List<Professor> professors=new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "student_subject" ,
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects=new ArrayList<>();



    @OneToOne(mappedBy = "student" ,cascade = CascadeType.ALL,orphanRemoval = true)
    private AdmissionRecord admissionRecord;  //inverse side
}
