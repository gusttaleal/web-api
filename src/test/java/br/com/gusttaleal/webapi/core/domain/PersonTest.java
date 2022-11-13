package br.com.gusttaleal.webapi.core.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PersonTest {
    private final Map<String, Object> fields = new HashMap<>();
    private Person person;

    @BeforeEach
    void setup() {
        person = Person
                .builder()
                .name("Name")
                .birthDate("01/01/2000")
                .naturalPersonsRegister("000.000.000-00")
                .registrationNumber(null)
                .secret(null)
                .build();

        fields.put("name", String.class);
        fields.put("birthDate", String.class);
        fields.put("naturalPersonsRegister", String.class);
        fields.put("registrationNumber", String.class);
        fields.put("secret", Map.class);
    }

    @Test
    @DisplayName("Should validate the fields of the Person class.")
    void shouldValidateFieldsPersonClass() {
        // Arrange
        var expectedFields = fields;
        var actualFields = person.getClass().getDeclaredFields();

        // Act
        Arrays.stream(actualFields).forEach(field ->
                {
                    var name = field.getName();
                    var type = field.getType();

                    //Assert
                    assertEquals(expectedFields.get(name), type);
                }
        );
    }
}
