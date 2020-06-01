package dev.sobue.google.storage;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

@SpringBootApplication
public class GoogleStorageDemoApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.exit(SpringApplication.run(GoogleStorageDemoApplication.class, args));
  }

  private final Resource gcsFile;

  public GoogleStorageDemoApplication(
      @Value("gs://${gcp-bucket}/test.txt") Resource gcsFile
  ) {
    this.gcsFile = gcsFile;
  }

  @Override
  public void run(String... args) throws Exception {
    System.err.println(
        StreamUtils.copyToString(gcsFile.getInputStream(), StandardCharsets.UTF_8) + "\n"
    );
  }
}
