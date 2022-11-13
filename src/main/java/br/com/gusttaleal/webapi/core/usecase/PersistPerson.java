package br.com.gusttaleal.webapi.core.usecase;

import br.com.gusttaleal.webapi.core.domain.Person;
import br.com.gusttaleal.webapi.core.exceptions.EncryptException;
import br.com.gusttaleal.webapi.core.repository.IPersistPersonInformations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PersistPerson {
    private static final String EXECUTE_METHOD_LOG = PersistPerson.class.getCanonicalName() + ":execute";
    private final IPersistPersonInformations iPersistPersonInformations;
    private final EncryptNaturalPersonsRegister encryptNaturalPersonsRegister;

    public String execute(final Person person) {

        log.info("[{}] Initializing process to persist a Person informations", EXECUTE_METHOD_LOG);

        try {
            encryptNaturalPersonsRegister.execute(person);

            var registrationNumber = iPersistPersonInformations.execute(person);

            log.info("[{}] Person informations persisted. ID: '{}'.", EXECUTE_METHOD_LOG, registrationNumber);
            return registrationNumber;

        } catch (EncryptException ex) {
            throw new EncryptException(EXECUTE_METHOD_LOG, ex);
        }
    }
}
