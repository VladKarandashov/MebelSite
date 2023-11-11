package com.example.mebelsite.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Min(0)
    @Max(50)
    @NotNull
    private Double width;
    @Min(0)
    @Max(50)
    @NotNull
    private Double height;
    @Min(0)
    @Max(50)
    @NotNull
    private Double length;
    @Min(0)
    @Max(60)
    private Integer productionTimeDays;

    private Long mebelType;
    private Long color;
    private Long furnitureBrand;
    private Long furnitureType;
    private Long material;

}