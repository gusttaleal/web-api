package br.com.gusttaleal.webapi.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Person {
    private String name;
    private String birthDate;
    private String naturalPersonsRegister;

    private String registrationNumber;
    private Map<String, Object> secret;
}
