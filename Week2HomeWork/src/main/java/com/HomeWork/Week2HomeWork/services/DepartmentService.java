package com.HomeWork.Week2HomeWork.services;


import com.HomeWork.Week2HomeWork.dto.DepartmentDTO;
import com.HomeWork.Week2HomeWork.entities.DepartmentEntity;
import com.HomeWork.Week2HomeWork.exceptions.ResourceNotFoundException;
import com.HomeWork.Week2HomeWork.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<DepartmentDTO>getDepartmentById(Long id){
        return departmentRepository.findById(id).map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class));
    }

    public List<DepartmentDTO> getAllDepartment(){
        List<DepartmentEntity> departmentEntities=departmentRepository.findAll();
       return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class))
               .collect(Collectors.toList());
    }
    public DepartmentDTO createNewDepartment(DepartmentDTO inputDepartment){
        DepartmentEntity toSaveEntity=modelMapper.map(inputDepartment,DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity=departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedDepartmentEntity,DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(Long departmentId,DepartmentDTO departmentDTO){
        isExistByDepartmentId(departmentId);
         DepartmentEntity departmentEntity=modelMapper.map(departmentDTO,DepartmentEntity.class);
         departmentEntity.setId(departmentId);
         DepartmentEntity savedDepartmentEntity=departmentRepository.save(departmentEntity);
         return modelMapper.map(savedDepartmentEntity,DepartmentDTO.class);
    }

    public boolean isExistByDepartmentId(Long departmentId){
        boolean Exists=departmentRepository.existsById(departmentId);
        if(!Exists) throw new ResourceNotFoundException("department not found with id : "+departmentId);
        return true;
    }

    public boolean deleteDepartmentById(Long departmentId){
        isExistByDepartmentId(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }


    public DepartmentDTO updatePartialDepartmentById(Long departmentId, Map<String,Object> updates){
        isExistByDepartmentId(departmentId);
        DepartmentEntity departmentEntity=departmentRepository.findById(departmentId).get();
        updates.forEach((field,value)->{
            Field fieldToBeUpdated= ReflectionUtils.findField(DepartmentEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,departmentEntity,value);

        });
        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDTO.class);
    }
}
