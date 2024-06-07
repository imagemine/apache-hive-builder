package com.github.skhatri.s3;

import com.amazonaws.auth.AWSCredentials;
import org.apache.hadoop.conf.Configuration;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TrinoCustomAwsCredentialsProviderTest {

    @Test
    public void testGetCredentials() {
        TrinoCustomAwsCredentialsProvider provider = new TrinoCustomAwsCredentialsProvider(URI.create("s3://bucket"), new Configuration());
        AWSCredentials credentials = provider.getCredentials();
        assertNotNull(credentials);
    }
}
