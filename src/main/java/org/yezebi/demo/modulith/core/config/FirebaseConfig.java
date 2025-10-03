package org.yezebi.demo.modulith.core.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yezebi.demo.modulith.core.properties.CoreProperties;

@Configuration
public class FirebaseConfig {
  @Bean
  FirebaseApp firebaseApp(final CoreProperties properties) throws IOException {
    final FirebaseOptions options =
        FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.getApplicationDefault())
            .setProjectId(properties.projectId())
            .build();

    return FirebaseApp.initializeApp(options);
  }
}
