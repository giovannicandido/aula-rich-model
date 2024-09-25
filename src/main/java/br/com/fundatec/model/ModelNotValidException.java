package br.com.fundatec.model;

import java.util.List;

public class ModelNotValidException extends RuntimeException {
    private final List<ValidationError> errors;

    public ModelNotValidException(List<ValidationError> errors) {
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ModelNotValidException{" +
                "errors=" + errors +
                '}';
    }
}
