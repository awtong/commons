package awt.commons.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class OneOfValidator implements ConstraintValidator<OneOf, String> {

    private String[] validValues;

    @Override
    public void initialize(final OneOf constraintAnnotation) {
        this.validValues = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext cvc) {
        return Arrays.asList(this.validValues).contains(value);
    }
}

