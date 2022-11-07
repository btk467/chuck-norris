/*
 * Copyright (c) 2022 Workers Compensation Board of Manitoba
 */
package org.btk467.cnjokes.config;

import java.util.concurrent.TimeUnit;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO
 * 
 * @author Victor
 */
@Configuration
public class CacheStaticResourcesConfiguration implements WebMvcConfigurer {

  /**
   * We provide a custom configuration which resolves URL-Requests to static files
   * in the classpath (src/main/resources directory).
   *
   * This overloads a default configuration retrieved at least partly from
   * {@link WebProperties.Resources#getStaticLocations()}.
   *
   * @param registry ResourceHandlerRegistry
   */
  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {

    registry.addResourceHandler("/favicon.ico")
        // trailing slash is important!
        .addResourceLocations("classpath:/static/")
        .setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS).noTransform().mustRevalidate());

    registry.addResourceHandler("/css/**")
        // trailing slash is important!
        .addResourceLocations("classpath:/static/css/")
        .setCacheControl(CacheControl.maxAge(7, TimeUnit.DAYS).noTransform().mustRevalidate());

    registry.addResourceHandler("/js/**")
        // trailing slash is important!
        .addResourceLocations("classpath:/static/js/")
        .setCacheControl(CacheControl.maxAge(7, TimeUnit.DAYS).noTransform().mustRevalidate());

    registry.addResourceHandler("/images/**")
        // trailing slash is important!
        .addResourceLocations("classpath:/static/images/")
        .setCacheControl(CacheControl.maxAge(7, TimeUnit.DAYS).noTransform().mustRevalidate());
  }
}
