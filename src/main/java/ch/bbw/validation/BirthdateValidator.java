package ch.bbw.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Instant;
import java.util.Date;

public class BirthdateValidator implements
        ConstraintValidator<BirthdateConstraint, Date> {

    @Override
    public void initialize(BirthdateConstraint birthdate) {
    }

    @Override
    public boolean isValid(Date birthdate,
                           ConstraintValidatorContext cxt) {
        return birthdate != null && birthdate.before(Date.from(Instant.parse("2005-01-01T00:00:00.00Z")));
    }

}
