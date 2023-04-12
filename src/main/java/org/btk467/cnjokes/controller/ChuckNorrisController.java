/*
 * Copyright (c) 2022 Workers Compensation Board of Manitoba
 */
package org.btk467.cnjokes.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.btk467.cnjokes.config.ChuckNorrisConfig;
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

  @GetMapping(value = {"/", "/randomJoke"})
  public String getRandomJoke(Model model) {

    model.addAttribute("cnRandomJokeUrl", ChuckNorrisConfig.RANDOM_JOKE_URL);
    return "cn-random-joke";
  }

  @GetMapping(value = {"/crash"})
  public String crash() {

    //this code should crash and send error to Sentry cloud service
    //Also this code s/b caught by quality control like SonarQube 
    List<String> strings = Arrays.asList("a1", "a2", "b1", "c2", "c1");
    Stream<String> pipeline = strings.stream().filter(b -> b.contains("2"));
    long count1 = pipeline.count();
    long count2 = pipeline.mapToLong(b -> b.length()).sum(); // Non-compliant;
    log.warn("Counts: {} {}", count1, count2);

    return "cn-random-joke";
  }

}
