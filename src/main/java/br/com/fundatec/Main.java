package br.com.fundatec;

import br.com.fundatec.model.Address;
import br.com.fundatec.model.ModelValidator;
import br.com.fundatec.model.State;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        State state = new State("", null, "Aqui vai dar bom");
        Address address = new Address("", null, null, state, null);
        List<ModelValidator> models = List.of(state, address);
        address.validate();
        validateAll(models);
    }

    public static void validateAll(List<ModelValidator> models) {
        for (ModelValidator model : models) {
            model.validate();
        }
    }
}