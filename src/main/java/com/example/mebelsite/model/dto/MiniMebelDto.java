package com.example.mebelsite.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ToString
public class MiniMebelDto {

    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private Double width;

    @NotNull
    private Double height;

    @NotNull
    private Double length;

    @NotNull
    private Integer productionTimeDays;

    private Long mebelType;
    private Long color;
    private Long furnitureBrand;
    private Long furnitureType;
    private Long material;

}