package br.com.fundatec.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class State implements ModelValidator {
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
}
