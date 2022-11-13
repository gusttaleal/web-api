package br.com.gusttaleal.webapi.core.usecase;

import br.com.gusttaleal.webapi.core.domain.Person;
import br.com.gusttaleal.webapi.core.exceptions.EncryptException;
import br.com.gusttaleal.webapi.core.utils.Encrypt;
import br.com.gusttaleal.webapi.core.utils.Secrets;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

@Slf4j
public class EncryptNaturalPersonsRegister {
    private static final String EXECUTE_METHOD_LOG = EncryptNaturalPersonsRegister.class.getSimpleName() + ":execute";

    public void execute(final Person person) {

        log.info("[{}] Initializing process to encrypt the Natural Persons Register.", EXECUTE_METHOD_LOG);

        try {
            final SecretKey key = Secrets.generateKey();
            person.getSecret().put("key", key);

            final IvParameterSpec ivSpec = Secrets.generateIv();
            person.getSecret().put("ivSpec", ivSpec);

            final String response = Encrypt.execute(person.getNaturalPersonsRegister(), key, ivSpec);
            person.setNaturalPersonsRegister(response);

            log.info("[{}] Natural Persons Register encrypted.", EXECUTE_METHOD_LOG);

        } catch (Exception ex) {
            throw new EncryptException(EXECUTE_METHOD_LOG, ex);
        }
    }
}
