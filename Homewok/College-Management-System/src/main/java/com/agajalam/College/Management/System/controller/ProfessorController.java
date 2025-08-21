package com.agajalam.College.Management.System.controller;

import com.agajalam.College.Management.System.dto.ProfessorDTO;
import com.agajalam.College.Management.System.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/professors")
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping()
    public ResponseEntity<Set<ProfessorDTO>>getAllProfessors(){
        return ResponseEntity.ok(professorService.getAllProfessors());
    }

}
