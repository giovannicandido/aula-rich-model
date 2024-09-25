package br.com.fundatec.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AddressTest {

    @Test
    @DisplayName("Should validate blank street")
    void validateStreet() {
        // Given
        Address address = new Address("", null, null, null, null);
        // When
        // Then

        ModelNotValidException exception = assertThrows(ModelNotValidException.class, () -> address.validate());
        List<ValidationError> errors = exception.getErrors();

        assertThat(errors).hasSize(4);
        assertThat(errors)
                .extracting("message")
                .contains("Street cannot be blank");

        assertThat(errors)
                .extracting("field")
                .contains("street");

    }

    @Test
    void validateValidAddress() {
        // Given
        Address address = new Address("street", 100, "Porto Alegre",
                new State("Rio Grande do Sul", "RS", "1289"),
                new CountryCode("BR"));

        assertDoesNotThrow(() -> address.validate());
    }
}