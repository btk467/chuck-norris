/*
 * Copyright (c) 2023 Workers Compensation Board of Manitoba
 */
package org.btk467.cnjokes.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.btk467.cnjokes.config.ChuckNorrisConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

/**
 * TODO
 * 
 * @author vscurtu
 */
@Import(ChuckNorrisConfig.class)
@WebMvcTest(ChuckNorrisController.class)
class ChuckNorrisControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void whenGetRootUriRandomJoke_thenValidResponseReturned() throws Exception {

    this.mockMvc.perform(get("/")).andExpect(status().isOk())
    .andExpect(content().string(containsString("Chuck Norris")));
  }

  @Test
  void whenGetRandomJoke_thenValidResponseReturned() throws Exception {

    this.mockMvc.perform(get("/randomJoke"))
    .andExpect(status().isOk())
    .andExpect(content().string(containsString("Chuck Norris")));
  }
  
  /**
   * Test method for {@link org.btk467.cnjokes.controller.ChuckNorrisController#crash()}.
   */
  @Test

  void testCrash() {
    Exception thrown = Assertions.assertThrows(Exception.class, () -> {
      mockMvc.perform(get("/crash"))
      .andExpect(status().isOk())
      .andExpect(content().string(containsString("Chuck Norris")));
    });

    Assertions.assertNotNull(thrown, "Expected Exception to be thrown.");
  }

}
