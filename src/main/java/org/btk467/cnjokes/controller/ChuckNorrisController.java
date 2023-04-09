/*
 * Copyright (c) 2022 Workers Compensation Board of Manitoba
 */
package org.btk467.cnjokes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Victor
 */
@Controller
@Slf4j
public class ChuckNorrisController {

  private static final String RANDOM_JOKE_URL = "https://api.chucknorris.io/jokes/random";

  //private final ChuckNorrisService service;

//  public ChuckNorrisController(ChuckNorrisService service) {
//    this.service = service;
//  }

  @GetMapping(value = {"/","/randomJoke"})
  public String getRandomJoke(Model model) {
    
//    
//    String randomJoke = service.getRandomJoke();
//
//    HttpHeaders headers = new HttpHeaders();
//    headers.add("user-agent", "Application");
//    HttpEntity<String> entity = new HttpEntity<>(headers);

    log.info("endpoint " + RANDOM_JOKE_URL );
    model.addAttribute("cnRandomJokeUrl", RANDOM_JOKE_URL);

    return "cn-random-joke";
  }
  
  @GetMapping(value = {"/crash"})
  public String crash() {
    int x = 1 / 0;
    return "cn-random-joke";
  }
  
}
