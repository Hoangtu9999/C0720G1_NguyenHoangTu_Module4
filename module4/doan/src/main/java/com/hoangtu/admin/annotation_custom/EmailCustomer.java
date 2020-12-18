package com.hoangtu.admin.annotation_custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {CustomEmail.class})
@Target({ FIELD })
@Retention(RUNTIME)
public @interface EmailCustomer {

    String message() default "This email is not valid";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
