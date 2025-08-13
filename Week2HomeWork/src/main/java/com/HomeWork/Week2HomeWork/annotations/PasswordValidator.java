package com.HomeWork.Week2HomeWork.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation,String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if(password==null) return false;
        if(password.length()<10) return false;

        boolean hasUpperCase=password.matches(".*[A-Z].*");
        boolean hasLowerCase=password.matches(".*[a-z].*");
        boolean hasDigit=password.matches(".*\\d.*");
        boolean hasSpecialChar=password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{}|;:'\"\\\\,.<>/?].*");
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }
}
