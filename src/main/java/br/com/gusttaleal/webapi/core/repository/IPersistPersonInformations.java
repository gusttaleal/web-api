package br.com.gusttaleal.webapi.core.repository;

import br.com.gusttaleal.webapi.core.domain.Person;

public interface IPersistPersonInformations {
    String execute(final Person person);
}
