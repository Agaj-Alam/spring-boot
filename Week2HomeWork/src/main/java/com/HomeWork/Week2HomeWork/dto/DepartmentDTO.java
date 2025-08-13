package com.HomeWork.Week2HomeWork.dto;

import com.HomeWork.Week2HomeWork.annotations.PasswordValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "title of Department  can't be blank")
    @Size(min = 3,max = 50 ,message = "title should be lies (3 to 50) character at least")
    private String title;

    @JsonProperty("isActive")
    @AssertTrue(message = "isActive must be true")
    private Boolean isActive;

//    @PastOrPresent(message = "date should be past or present")
//    @FutureOrPresent(message = "data should be future or present")
//    @Past(message = "data should be only past")
    @Future(message = "data should be only future")
    private LocalDate createdAt;

    @PasswordValidation
    private String password;

    @CreditCardNumber
    private String creditCard;

    @URL(message = "invalid URL")
    private String website;
}
