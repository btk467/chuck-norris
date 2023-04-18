/*
 * Copyright (c) 2023 Workers Compensation Board of Manitoba
 */
package org.btk467.cnjokes.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.btk467.cnjokes.config.ChuckNorrisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * TODO
 * @author vscurtu
 */
@Import(ChuckNorrisConfig.class)
@WebMvcTest(ChuckNorrisProxyApi.class)
class ChuckNorrisProxyApiTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void whenGetRandomJoke_thenValidResponseReturned() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders
        .get("/api/randomJoke")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.url").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.url").isNotEmpty());

  }

}
