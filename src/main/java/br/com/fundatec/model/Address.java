package br.com.fundatec.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Address implements ModelValidator {
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
