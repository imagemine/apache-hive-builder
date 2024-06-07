package com.github.skhatri.s3;

import com.amazonaws.auth.AWSCredentials;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CredentialsFactoryTest {

    @Test
    public void testCreate() {
        AWSCredentials credentials = CredentialsFactory.create();
        assertNotNull(credentials);
    }
}
