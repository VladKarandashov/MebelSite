package com.example.mebelsite.controller;

import com.example.mebelsite.model.entity.business.ColorEntity;
import com.example.mebelsite.model.entity.business.FurnitureTypeEntity;
import com.example.mebelsite.model.entity.business.MebelEntity;
import com.example.mebelsite.model.entity.business.MebelTypeEntity;
import com.example.mebelsite.model.repository.ColorRepository;
import com.example.mebelsite.model.repository.FurnitureTypeRepository;
import com.example.mebelsite.model.repository.MebelRepository;
import com.example.mebelsite.model.repository.MebelTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SearchRestController {

    private final MebelTypeRepository mebelTypeRepository;
    private final ColorRepository colorRepository;
    private final FurnitureTypeRepository furnitureTypeRepository;

    private final MebelRepository mebelRepository;

    @GetMapping("/api/search")
    public List<MebelEntity> show(@RequestParam(required = false, defaultValue = "0") Long idMebelType,
                                  @RequestParam(required = false, defaultValue = "0") Long idColor,
                                  @RequestParam(required = false, defaultValue = "0") Long idFurnitureType) {
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
}
