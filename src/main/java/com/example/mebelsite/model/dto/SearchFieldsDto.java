package com.example.mebelsite.model.dto;

import com.example.mebelsite.model.entity.business.ColorEntity;
import com.example.mebelsite.model.entity.business.FurnitureTypeEntity;
import com.example.mebelsite.model.entity.business.MebelTypeEntity;
import lombok.Data;

import java.util.List;

@Data
public class SearchFieldsDto {

    private List<MebelTypeEntity> mebelTypes;

    private List<ColorEntity> colors;

    private List<FurnitureTypeEntity> furnitureTypes;

    public SearchFieldsDto(List<MebelTypeEntity> mebelTypes, List<ColorEntity> colors, List<FurnitureTypeEntity> furnitureTypes) {
        this.mebelTypes = mebelTypes;
        this.colors = colors;
        this.furnitureTypes = furnitureTypes;
    }
}
