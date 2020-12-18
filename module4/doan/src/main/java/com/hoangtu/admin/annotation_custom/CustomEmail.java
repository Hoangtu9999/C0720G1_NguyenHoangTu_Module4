package com.hoangtu.admin.annotation_custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomEmail implements ConstraintValidator<EmailCustomer,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return false;
    }
}
