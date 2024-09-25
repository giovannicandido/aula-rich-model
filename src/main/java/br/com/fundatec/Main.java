package br.com.fundatec;

import br.com.fundatec.model.Address;
import br.com.fundatec.model.State;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        State state = new State("", null, "Aqui vai dar bom");
        Address address = new Address("", null, null, state, null);
        address.validate();

    }
}