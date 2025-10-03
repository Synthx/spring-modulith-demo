package org.yezebi.demo.modulith.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.VirtualThreadTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
public class AsyncConfig {
  @Bean
  AsyncTaskExecutor taskExecutor() {
    return new VirtualThreadTaskExecutor();
  }
}
