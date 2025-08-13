package com.agajalam.HospitalManagement.HospitalManagement.dto;

import com.agajalam.HospitalManagement.HospitalManagement.entities.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
