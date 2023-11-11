package com.example.mebelsite.service;

import com.example.mebelsite.model.dto.SearchFieldsDto;
import com.example.mebelsite.model.entity.business.ColorEntity;
import com.example.mebelsite.model.entity.business.FurnitureTypeEntity;
import com.example.mebelsite.model.entity.business.MebelEntity;
import com.example.mebelsite.model.entity.business.MebelTypeEntity;
import com.example.mebelsite.model.repository.ColorRepository;
import com.example.mebelsite.model.repository.FurnitureTypeRepository;
import com.example.mebelsite.model.repository.MebelRepository;
import com.example.mebelsite.model.repository.MebelTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final MebelRepository mebelRepository;

    private final MebelTypeRepository mebelTypeRepository;
    private final ColorRepository colorRepository;
    private final FurnitureTypeRepository furnitureTypeRepository;

    public List<MebelEntity> getMebelList(Long idMebelType, Long idColor, Long idFurnitureType) {
        var mebelType = idMebelType == 0 ?
                new MebelTypeEntity() :
                mebelTypeRepository.findById(idMebelType).orElseThrow(() -> new RuntimeException("Не твори фигню!"));
        var color = idColor == 0 ?
                new ColorEntity() :
                colorRepository.findById(idColor).orElseThrow(() -> new RuntimeException("Не твори фигню!"));
        var furnitureType = idFurnitureType == 0 ?
                new FurnitureTypeEntity() :
                furnitureTypeRepository.findById(idFurnitureType).orElseThrow(() -> new RuntimeException("Не твори фигню!"));

        return mebelRepository.findAll().parallelStream()
                .filter(el -> idMebelType == 0 || mebelType.equals(el.getMebelType()))
                .filter(el -> idColor == 0 || color.equals(el.getColor()))
                .filter(el -> idFurnitureType == 0 || furnitureType.equals(el.getFurnitureType()))
                .toList();
    }

    public SearchFieldsDto getSearchDto(List<MebelEntity> mebelList) {

        var mebelTypes = mebelList.stream()
                .map(MebelEntity::getMebelType)
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.comparing(MebelTypeEntity::getTitle))
                .toList();
        var colors = mebelList.stream()
                .map(MebelEntity::getColor)
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.comparing(ColorEntity::getTitle))
                .toList();
        var furnitureTypes = mebelList.stream()
                .map(MebelEntity::getFurnitureType)
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.comparing(FurnitureTypeEntity::getTitle))
                .toList();

        return new SearchFieldsDto(mebelTypes, colors, furnitureTypes);
    }
}