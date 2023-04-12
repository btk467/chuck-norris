/*
 * Copyright (c) 2023 Workers Compensation Board of Manitoba
 */
package org.btk467.cnjokes.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * TODO
 * @author Victor
 */
@Data
public class ChuckNorrisJokeDto {
    @JsonIgnore  
    private String[] categories;
  
    private String created_at;
    private String icon_url;
    private String id;
    private String updated_at;
    private String url;
    private String value;
}