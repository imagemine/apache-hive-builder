package com.github.skhatri.s3;

import com.amazonaws.auth.AWSCredentials;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AwsCustomCredentialsProviderTest {

    @Test
    public void testGetCredentials() {
        AwsCustomCredentialsProvider provider = new AwsCustomCredentialsProvider();
        AWSCredentials credentials = provider.getCredentials();
        assertNotNull(credentials);
    }
}
