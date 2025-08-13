package com.RESTfulAPIs.Weak2.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = {PrimeNumberValidator.class})
public @interface PrimeNumberValidation {

    String message() default "number is not a prime";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
