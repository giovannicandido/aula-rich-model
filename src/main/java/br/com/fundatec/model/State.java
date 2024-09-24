package br.com.fundatec.model;

import java.util.ArrayList;
import java.util.List;

public class State {
    private final static int MAX_NAME_SIZE = 100;
    private final String name;
    private final String abbreviation;
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
        List<ValidationError> errors = new ArrayList<>();
        if(name == null || name.isEmpty()) {
            errors.add(new ValidationError("Name cannot be null", "name"));
        }

        if(name.length() > MAX_NAME_SIZE) {
            errors.add(new ValidationError("Name is greater then max size", "name"));
        }

        if(abbreviation == null || abbreviation.isEmpty()) {
            errors.add(new ValidationError("Abbreviation cannot be null", "abbreviation"));
        }

        if(ibgeCode == null || ibgeCode.isEmpty()) {
            errors.add(new ValidationError("IbgeCode cannot be null", "ibgeCode"));
        }

        if(!errors.isEmpty()) {
            throw new ModelNotValidException(errors);
        }
    }
}
