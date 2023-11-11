package com.example.mebelsite.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountMebelByMebelType {
    private String mebelTypeTitle;
    private Long count;
}