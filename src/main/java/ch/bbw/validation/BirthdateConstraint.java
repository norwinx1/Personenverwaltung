package ch.bbw.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BirthdateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BirthdateConstraint {
    String message() default "Invalid birthdate";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
