package br.com.gusttaleal.webapi.core.exceptions;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EncryptExceptionTest {
    private static final String ENCRYPT_EXCEPTION_LOG = EncryptException.class.getSimpleName() + ":constructor";
    private static final String origin = EncryptExceptionTest.class.getSimpleName();
    private static LogCaptor LOG_CAPTOR;

    @AfterAll
    static void closeLogCaptor() {
        LOG_CAPTOR.close();
    }

    @BeforeEach
    void setUp() {
        LOG_CAPTOR = LogCaptor.forClass(EncryptException.class);
    }

    @AfterEach
    void cleanUpLogCaptor() {
        LOG_CAPTOR.clearLogs();
    }


    @Test
    @DisplayName("Should validate the fields of the Person class.")
    void shouldValidateFieldsPersonClass() {
        // Arrange
        var expected = String.format("[%s] Origin: '%s'. Error: ", ENCRYPT_EXCEPTION_LOG, origin);
        var throwable = new RuntimeException("", new Throwable());

        // Act
        assertThrows(EncryptException.class, () -> {
            throw new EncryptException(origin, throwable);
        });
        var actual = LOG_CAPTOR.getErrorLogs().get(0);

        //Assert
        assertEquals(expected, actual);

    }
}
