package br.com.gusttaleal.webapi.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @NotNull(message = "The field can not be null")
    @NotBlank(message = "The full name can not be blank.")
    @NotEmpty(message = "The full name can not be empty.")
    private String name;

    @NotNull(message = "The field can not be null, fill following the eg: DD/MM/YYYY.")
    @NotBlank(message = "The birth date can not be blank, fill following the eg: DD/MM/YYYY.")
    @NotEmpty(message = "The birth date can not be empty, fill following the eg: DD/MM/YYYY.")
    @Pattern(regexp = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$", message = "The birth date is invalid, fill following the eg: 00/00/0000.")
    private String birthDate;

    @NotNull(message = "The field can not be null, fill following the eg: 000.000.000-00.")
    @NotBlank(message = "The full number can not be blank, fill following the eg: 000.000.000-00.")
    @NotEmpty(message = "The full number can not be empty, fill following the eg: 000.000.000-00.")
    @Pattern(regexp = "^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$", message = "The Natural Persons Register is invalid, fill following the eg: 000.000.000-00.")
    private String naturalPersonsRegister;

}
