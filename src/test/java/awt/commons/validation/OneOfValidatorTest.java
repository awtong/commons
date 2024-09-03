package awt.commons.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OneOfValidatorTest {

    @Mock
    private ConstraintValidatorContext mockConstraintValidatorContext;

    @Mock
    private OneOf mockOneOf;

    private OneOfValidator oneOfValidator;

    @BeforeEach
    void setUp() {
        when(mockOneOf.value()).thenReturn(new String[]{"good", "valid"});

        this.oneOfValidator = new OneOfValidator();
        this.oneOfValidator.initialize(this.mockOneOf);
    }

    @Test
    @DisplayName("When not valid, return false")
    void when_invalid_value_return_false() {
        assertFalse(this.oneOfValidator.isValid("invalid", mockConstraintValidatorContext));
    }

    @Test
    @DisplayName("When valid, return true")
    void when_valid_value_return_true() {
        assertTrue(this.oneOfValidator.isValid("valid", mockConstraintValidatorContext));
    }
}