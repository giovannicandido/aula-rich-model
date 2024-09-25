package br.com.fundatec.utils;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidationFabric {
    private static Validator INSTANCE;

    public static Validator buildValidator() {
        if(INSTANCE != null) {
            return INSTANCE;
        }
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        INSTANCE = validatorFactory.getValidator();
        return INSTANCE;
    }
}
