package org.yezebi.demo.modulith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("org.yezebi.demo.modulith")
public class DemoModulithApplication {
  public static void main(final String[] args) {
    SpringApplication.run(DemoModulithApplication.class, args);
  }
}
