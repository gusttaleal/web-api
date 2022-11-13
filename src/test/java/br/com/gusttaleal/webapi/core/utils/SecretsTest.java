package br.com.gusttaleal.webapi.core.utils;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SecretsTest {

    @Test
    void ShouldValidateThePrivateConstructor() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        // Arrange
        Constructor<Secrets> constructor = Secrets.class.getDeclaredConstructor();

        // Act
        constructor.setAccessible(true);
        constructor.newInstance();

        //Assert
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
    }
}
