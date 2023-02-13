/*
 * Copyright (c) 2022 Workers Compensation Board of Manitoba
 */
package org.btk467.cnjokes.service.impl;

import org.btk467.cnjokes.service.ChuckNorrisService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 * @author Victor
 */
@Service
class ChuckNorrisServiceImpl implements ChuckNorrisService {

  final RestTemplate restTemplate;

  ChuckNorrisServiceImpl(RestTemplate chuckNorrisRestService) {
    this.restTemplate = chuckNorrisRestService;
  }

  @Override
  public String getRandomJoke() {
    return restTemplate.getForObject(RANDOM_JOKE_URL, String.class);
  }
}
