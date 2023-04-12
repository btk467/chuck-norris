/*
 * Copyright (c) 2022 Workers Compensation Board of Manitoba
 */
package org.btk467.cnjokes.controller;

import org.btk467.cnjokes.config.ChuckNorrisConfig;
import org.btk467.cnjokes.dto.ChuckNorrisJokeDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Proxy call to Chuck Norris Jokes Api
 * @author Victor
 */
@RestController
public class ChuckNorrisProxyApi {

  final RestTemplate restTemplate;
  final HttpHeaders proxyHeaders;
  
  ChuckNorrisProxyApi(RestTemplate restTemplate, HttpHeaders proxyHeaders) {
    this.restTemplate = restTemplate;
    this.proxyHeaders = proxyHeaders;
  }

  @GetMapping("/api/randomJoke")
  public ResponseEntity<ChuckNorrisJokeDto> randomJoke() throws Exception {

    HttpEntity<String> entity = new HttpEntity<>("", proxyHeaders);
    ResponseEntity<ChuckNorrisJokeDto> response = restTemplate.exchange(ChuckNorrisConfig.RANDOM_JOKE_URL, HttpMethod.GET, entity, ChuckNorrisJokeDto.class);

    return ResponseEntity.ok(response.getBody());
  }



}
