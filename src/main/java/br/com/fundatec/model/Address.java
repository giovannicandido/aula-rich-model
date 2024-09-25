package br.com.fundatec.model;

import jakarta.validation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Address {
    @NotBlank(message = "Street cannot be blank")
    private final String street;
    @NotNull(message = "Number cannot be null")
    private final Integer number;
    @NotBlank
    private final String city;
    @Valid
    @NotNull
    private final State state;
    private final CountryCode countryCode;

    public Address(String street, Integer number, String city, State state, CountryCode countryCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.countryCode = countryCode;
        validate();
    }

    public void validate() {

        //if (street == null || street.isEmpty()) {
        //    errors.add(new ValidationError("Street cannot be null", "street"));
       // }

       // if (number == null) {
       //     errors.add(new ValidationError("Number cannot be null", "number"));
       // }


        // Tirar daqui
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<Address>> constraintViolations = validator.validate(this);
        List<ValidationError> errors = constraintViolations.stream().map(violation -> {
            return new ValidationError(violation.getMessage(), violation.getPropertyPath().toString());
        }).toList();

        if(!errors.isEmpty()) {
            throw new ModelNotValidException(errors);
        }

    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public State getState() {
        return state;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }
}
