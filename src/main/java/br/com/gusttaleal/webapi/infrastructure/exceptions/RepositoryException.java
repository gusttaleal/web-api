package br.com.gusttaleal.webapi.infrastructure.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RepositoryException extends RuntimeException {
    private static final String REPOSITORY_EXCEPTION_LOG = RepositoryException.class.getSimpleName() + ":constructor";

    public RepositoryException(final String origin, final Exception ex) {
        super(ex.getMessage(), ex.getCause());
        log.error("[{}] Origin: '{}'. Error: ", REPOSITORY_EXCEPTION_LOG, origin, ex);
    }
}
