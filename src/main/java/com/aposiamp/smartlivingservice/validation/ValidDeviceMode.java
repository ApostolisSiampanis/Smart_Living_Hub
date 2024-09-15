package com.aposiamp.smartlivingservice.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DeviceModeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDeviceMode {
    String message() default "Invalid device mode for the given device type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
