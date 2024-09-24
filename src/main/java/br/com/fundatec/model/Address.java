package br.com.fundatec.model;

import java.util.ArrayList;
import java.util.List;

public class Address {
    private final String street;
    private final Integer number;
    private final String city;
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
        List<ValidationError> errors = new ArrayList<>();
        if (street == null || street.isEmpty()) {
            errors.add(new ValidationError("Street cannot be null", "street"));
        }

        if (number == null) {
            errors.add(new ValidationError("Number cannot be null", "number"));
        }

        if(!errors.isEmpty()) {
            throw new ModelNotValidException(errors);
        }
        state.validate();
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
