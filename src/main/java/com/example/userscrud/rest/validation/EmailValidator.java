package com.example.userscrud.rest.validation;

import com.example.userscrud.exception.UserValidationException;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    private static final String EMAIL_REGEX = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
            + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(StringUtils.isNotEmpty(email) && !email.matches(EMAIL_REGEX)) {
            throw new UserValidationException(String.format("Invalid email %s", email));
        }
        return true;
    }
}
