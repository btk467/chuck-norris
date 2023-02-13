/*
 * Copyright (c) 2022 Workers Compensation Board of Manitoba
 */
package org.btk467.cnjokes.service;

/**
 * TODO
 * @author Victor
 */
public interface ChuckNorrisService {
  
  static final String RANDOM_JOKE_URL = "https://api.chucknorris.io/jokes/random";

  String getRandomJoke();

}
