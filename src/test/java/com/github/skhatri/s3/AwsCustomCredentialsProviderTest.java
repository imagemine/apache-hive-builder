package com.github.skhatri.s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mockStatic;

public class AwsCustomCredentialsProviderTest {

    @BeforeAll
    public static void setUp() {
        System.setProperty("STORE_KEY", "testAccessKey");
        System.setProperty("STORE_SECRET", "testSecretKey");
        System.setProperty("STORE_ROLE_ARN", "testRoleArn");
        System.setProperty("STORE_TOKEN_FILE", "testTokenFile");
        System.setProperty("AWS_ROLE_SESSION_NAME", "testSessionName");
    }

    @Test
    public void testGetCredentials() {
        try (MockedStatic<CredentialsFactory> mockedFactory = mockStatic(CredentialsFactory.class)) {
            mockedFactory.when(CredentialsFactory::create).thenReturn(new BasicAWSCredentials("testAccessKey", "testSecretKey"));

            AwsCustomCredentialsProvider provider = new AwsCustomCredentialsProvider();
            AWSCredentials credentials = provider.getCredentials();
            assertNotNull(credentials);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to get credentials: " + e.getMessage());
        }
    }
}
