package br.com.gusttaleal.webapi.core.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Encrypt {
    private static final String EXECUTE_METHOD_LOG = Encrypt.class.getSimpleName() + ":execute";

    public static String execute(
            final String input,
            final SecretKey key,
            final IvParameterSpec ivSpec
    ) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        log.info("[{}] Initializing process to encrypt data.", EXECUTE_METHOD_LOG);

        final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

        final byte[] response = cipher.doFinal(input.getBytes());

        log.info("[{}] Data encrypted.", EXECUTE_METHOD_LOG);
        return Base64.getEncoder().encodeToString(response);
    }
}
