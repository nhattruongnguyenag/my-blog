package com.nhattruongnguyen.validator.anotation;

import com.nhattruongnguyen.validator.contrains.SlugValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SlugValidator.class)
@ReportAsSingleViolation
public @interface Slug {
    String message() default "";
    String messageInRange() default "";
    String messageUnique() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
