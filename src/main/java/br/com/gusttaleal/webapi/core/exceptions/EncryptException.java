package br.com.gusttaleal.webapi.core.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EncryptException extends RuntimeException {
    private static final String ENCRYPT_EXCEPTION_LOG = EncryptException.class.getSimpleName() + ":constructor";

    public EncryptException(final String origin, final Throwable throwable) {
        super(throwable.getMessage(), throwable.getCause());
        log.error(String.format("[%s] Origin: '%s'. Error: ", ENCRYPT_EXCEPTION_LOG, origin), throwable);

    }
}
