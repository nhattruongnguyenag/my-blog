package com.nhattruongnguyen.validator.anotation;

import com.nhattruongnguyen.validator.contrains.TitleValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TitleValidator.class)
public @interface Title {
    String message() default "{postEdit.titleLength}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
