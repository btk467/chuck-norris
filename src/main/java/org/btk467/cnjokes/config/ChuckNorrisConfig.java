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

//  @Bean
//  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//      return builder.routes()
//          .
//          .build();
//  }
//  
//  @Bean
//  public RouteLocator dynamicZipCodeRoute(RouteLocatorBuilder builder) {
//      return builder.routes()
//        .route("dynamicRewrite", r ->
//           r.path("/v2/zip/**")
//            .filters(f -> f.filter((exchange, chain) -> {
//                ServerHttpRequest req = exchange.getRequest();
//                addOriginalRequestUrl(exchange, req.getURI());
//                String path = req.getURI().getRawPath();
//                String newPath = path.replaceAll(
//                  "/v2/zip/(?<zipcode>.*)", 
//                  "/api/zip/${zipcode}-" + String.format("%03d", rnd.nextInt(1000)));
//                ServerHttpRequest request = req.mutate().path(newPath).build();
//                exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, request.getURI());
//                return chain.filter(exchange.mutate().request(request).build());
//            }))
//            .uri(backendUri))
//        .build();
//  }  
}
