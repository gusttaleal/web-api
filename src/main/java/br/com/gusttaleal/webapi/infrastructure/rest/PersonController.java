package br.com.gusttaleal.webapi.infrastructure.rest;

import br.com.gusttaleal.webapi.infrastructure.rest.dto.Request;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@ResponseStatus
@RequiredArgsConstructor
@RequestMapping("${context-path}")
public class PersonController {

    @PostMapping("/create/person")
    public ResponseEntity<Request> read(@Valid @RequestBody Request request) {

        return ResponseEntity.status(HttpStatus.OK).body(request);
    }
}
