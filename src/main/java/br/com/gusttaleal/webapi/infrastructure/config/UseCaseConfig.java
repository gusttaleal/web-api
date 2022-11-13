package br.com.gusttaleal.webapi.infrastructure.config;

import br.com.gusttaleal.webapi.core.repository.IPersistPersonInformations;
import br.com.gusttaleal.webapi.core.usecase.EncryptNaturalPersonsRegister;
import br.com.gusttaleal.webapi.core.usecase.PersistPerson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public PersistPerson persistPerson(
            final IPersistPersonInformations persistPersonsInformations,
            final EncryptNaturalPersonsRegister encryptNaturalPersonsRegister
    ) {
        return new PersistPerson(persistPersonsInformations, encryptNaturalPersonsRegister);

    }

    @Bean
    EncryptNaturalPersonsRegister encryptNaturalPersonsRegister() {
        return new EncryptNaturalPersonsRegister();
    }
}
