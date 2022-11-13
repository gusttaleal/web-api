package br.com.gusttaleal.webapi.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    @NotNull(message = "The field can not be null.")
    @NotBlank(message = "The id key can not be blank.")
    @NotEmpty(message = "The id key can not be empty.")
    private String registrationNumber;
}
