package com.example.mebelsite.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsRequest {

    private String title;

    private String description;

    private String link;

    private String author;

    private String imageLink;
}