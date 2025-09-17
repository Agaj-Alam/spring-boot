package com.agajalam.SecurityApp.Week5.DTO;

import com.agajalam.SecurityApp.Week5.entities.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDTO {
    private String name;
    private String email;
    private String password;

    private Set<Role> roles;
}
