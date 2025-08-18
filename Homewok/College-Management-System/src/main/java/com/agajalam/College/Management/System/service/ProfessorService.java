package com.agajalam.College.Management.System.service;

import com.agajalam.College.Management.System.dto.ProfessorDTO;
import com.agajalam.College.Management.System.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ModelMapper modelMapper;

    public Set<ProfessorDTO> getAllProfessors(){
        return professorRepository.findAll()
                .stream()
                .map(professor ->modelMapper.map(professor,ProfessorDTO.class) )
                .collect(Collectors.toSet());
    }

    private Optional<ProfessorDTO> getProfessorById(Long id){
        return professorRepository.findById(id)
                .map(professor -> modelMapper.map(professor,ProfessorDTO.class));
    }

}
