package com.RESTfulAPIs.Weak2.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EvenOddValidator implements ConstraintValidator<EvenOddValidation,Integer> {
    @Override
    public boolean isValid(Integer num, ConstraintValidatorContext constraintValidatorContext) {
        if(num%2==0)return true;
        return false;
    }
}
