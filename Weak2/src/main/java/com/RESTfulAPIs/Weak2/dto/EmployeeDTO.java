package com.RESTfulAPIs.Weak2.dto;

import com.RESTfulAPIs.Weak2.annotations.EmployeeRoleValidation;
import com.RESTfulAPIs.Weak2.annotations.EvenOddValidation;
import com.RESTfulAPIs.Weak2.annotations.PrimeNumberValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.lang.Integer;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "name of the employee can't be blank")
    @Size(min = 3,max = 10 ,message = "name should be lies (3 to 10) character at least")
    private String name;

    @NotBlank(message = "email of the employee can't be blank")
    @Email
    private String email;
//
//    @NotBlank(message = "age of the employee can't be blank")
//    @Min(value = 18, message = "age of employee cannot be less than 18")
//    @Max(value = 80 , message = "age of the employee can't be greater than 80")
    private Integer age;

    @NotBlank(message = "role of the employee can't be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "role of employee can either ADMIN or USER")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "salary of employee should be not null") @Positive(message = "salary of emp should be positive ")
    @DecimalMax( message = "salary must be less than : 20000.70",value = "20000.70")
    @DecimalMin(message = "salary must be greater than : 200.15",value = "200.15")
    private Double salary;

    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    @AssertTrue(message = " isActive status must be true")
    private Boolean isActive;

    @PrimeNumberValidation
    private Integer prime;

    @EvenOddValidation
    private Integer evenOdd;

}
