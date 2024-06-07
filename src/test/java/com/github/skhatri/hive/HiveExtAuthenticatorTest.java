package com.github.skhatri.hive;

import org.apache.hive.service.auth.PasswdAuthenticationProvider;
import org.junit.jupiter.api.Test;

import javax.security.sasl.AuthenticationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HiveExtAuthenticatorTest {

    @Test
    public void testAuthenticateSuccess() throws AuthenticationException {
        PasswdAuthenticationProvider authenticator = new HiveExtAuthenticator();
        authenticator.Authenticate("user", "password");
    }

    @Test
    public void testAuthenticateFailure() {
        PasswdAuthenticationProvider authenticator = new HiveExtAuthenticator();
        assertThrows(AuthenticationException.class, () -> {
            authenticator.Authenticate("user", "wrongpassword");
        });
    }
}
