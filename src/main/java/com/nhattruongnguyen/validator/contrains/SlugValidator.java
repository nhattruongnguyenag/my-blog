package com.nhattruongnguyen.validator.contrains;

import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.repository.PostRepository;
import com.nhattruongnguyen.validator.anotation.Slug;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlugValidator implements ConstraintValidator<Slug, String> {
    @Autowired
    private PostRepository postRepository;
    private String messageInRange;
    private String messageUnique;

    @Override
    public void initialize(Slug constraintAnnotation) {
        this.messageInRange = constraintAnnotation.messageInRange();
        this.messageUnique = constraintAnnotation.messageUnique();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        if (value == null || !value.matches("^[\\w]+[\\w-]{10,255}$")) {
            context.buildConstraintViolationWithTemplate(messageInRange).addConstraintViolation();
            return false;
        }

        PostEntity postEntity = postRepository.findBySlug(value);
        if (postEntity != null) {
            context.buildConstraintViolationWithTemplate(messageUnique).addConstraintViolation();
            return false;
        }

        return true;
    }
}
