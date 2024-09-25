package br.com.fundatec.model;

import br.com.fundatec.utils.ValidationFabric;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;

public interface ModelValidator {
    default void validate() {
        Validator validator = ValidationFabric.buildValidator();

        ModelValidator object = (ModelValidator) this;

        Set<ConstraintViolation<ModelValidator>> constraintViolations = validator.validate(object);
        List<ValidationError> errors = constraintViolations.stream().map(violation -> {
            return new ValidationError(violation.getMessage(), violation.getPropertyPath().toString());
        }).toList();

        if(!errors.isEmpty()) {
            throw new ModelNotValidException(errors);
        }

    }
}
