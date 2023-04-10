/*
 * Copyright (c) 2022 Workers Compensation Board of Manitoba
 */
package org.btk467.cnjokes.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 * @author Victor
 */
@Configuration
public class ChuckNorrisConfig {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
      return builder.build();
  }
}
