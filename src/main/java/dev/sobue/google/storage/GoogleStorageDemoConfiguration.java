package dev.sobue.google.storage;

import com.google.api.gax.core.CredentialsProvider;
import com.google.auth.oauth2.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
public class GoogleStorageDemoConfiguration {

  private final Environment environment;

  @Bean
  public CredentialsProvider credentialsProvider() {
    return () -> UserCredentials.newBuilder()
        .setClientId(environment.getProperty("token.client-id"))
        .setClientSecret(environment.getProperty("token.client-secret"))
        .setRefreshToken(environment.getProperty("token.refresh-token"))
        .build();
  }
}
