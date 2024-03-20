package com.nhattruongnguyen.validator.contrains;


import com.nhattruongnguyen.validator.anotation.Title;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TitleValidator implements ConstraintValidator<Title, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("^(?=.*\\w)[\\w']{1,255}$");
    }
}
