/*
 * Copyright (c) 2022 Workers Compensation Board of Manitoba
 */
package org.btk467.cnjokes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * @author Victor
 */
@Configuration
public class ChuckNorrisConfig {

  public static final String RANDOM_JOKE_URL = "https://api.chucknorris.io/jokes/random";

  @Bean
  RestTemplate restTemplate() {
      return new RestTemplate();
  }
  
  @Bean
  HttpHeaders proxyHttpHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("User-Agent", "Chrome/58.0.3029.110");
    
    return headers;
  }

}
