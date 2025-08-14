package com.agajalam.HospitalManagement.HospitalManagement.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 200)
    private String reason;

    @ManyToOne (fetch = FetchType.LAZY)//owning side
    @ToString.Exclude
    @JoinColumn(nullable = false)
    @JsonIgnore
    private Patient patient;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(nullable = false)
    @JsonIgnore
    private Doctor doctor;
}
