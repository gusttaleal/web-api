package br.com.gusttaleal.webapi.core.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Map;

@Data
@Builder
public class Person {
    @NonNull
    private String name;
    @NonNull
    private String birthDate;
    @NonNull
    private String naturalPersonsRegister;

    private String registrationNumber;
    private Map<String, Object> secret;
}
