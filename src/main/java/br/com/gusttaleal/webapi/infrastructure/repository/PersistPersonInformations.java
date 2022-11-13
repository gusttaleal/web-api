package br.com.gusttaleal.webapi.infrastructure.repository;

import br.com.gusttaleal.webapi.core.domain.Person;
import br.com.gusttaleal.webapi.core.repository.IPersistPersonInformations;
import br.com.gusttaleal.webapi.infrastructure.exceptions.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class PersistPersonInformations implements IPersistPersonInformations {
    private static final String EXECUTE_METHOD_LOG = PersistPersonInformations.class.getSimpleName() + ": execute";

    @Override
    public String execute(Person person) {
        log.info("[{}] Initializing to persist a Person informations", EXECUTE_METHOD_LOG);
        try {
            //TODO: Develop repository features
            return "a839fdf8-d33d-4e54-8267-6d16dace7ebd";
        } catch (Exception ex) {
            throw new RepositoryException(EXECUTE_METHOD_LOG, ex);
        }
    }
}
