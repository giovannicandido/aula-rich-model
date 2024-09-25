package br.com.fundatec.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class State {
    private final static int MAX_NAME_SIZE = 100;
    @NotBlank(message = "Name cannot be blank")
    @Size(max = MAX_NAME_SIZE, message = "Name cannot be greater then 100")
    private final String name;
    @NotBlank
    private final String abbreviation;
    @NotBlank
    private final String ibgeCode;

    public State(String name, String abbreviation, String ibgeCode) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.ibgeCode = ibgeCode;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getIbgeCode() {
        return ibgeCode;
    }

    public void validate() {
        // Tirar daqui
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<State>> constraintViolations = validator.validate(this);
        List<ValidationError> errors = constraintViolations.stream().map(violation -> {
            return new ValidationError(violation.getMessage(), violation.getPropertyPath().toString());
        }).toList();

        if(!errors.isEmpty()) {
            throw new ModelNotValidException(errors);
        }
    }
}
