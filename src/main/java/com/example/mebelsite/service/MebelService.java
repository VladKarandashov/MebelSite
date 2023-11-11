package com.example.mebelsite.service;

import com.example.mebelsite.model.dto.MiniMebelDto;
import com.example.mebelsite.model.entity.business.MebelEntity;
import com.example.mebelsite.model.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MebelService {

    private final MebelRepository mebelRepository;

    private final MebelTypeRepository mebelTypeRepository;
    private final ColorRepository colorRepository;
    private final FurnitureBrandRepository furnitureBrandRepository;
    private final FurnitureTypeRepository furnitureTypeRepository;
    private final MaterialRepository materialRepository;

    @Transactional
    public void deleteMebel(Long id) {
        if (id == null || !mebelRepository.existsById(id)) {
            throw new RuntimeException();
        }
        var mebel = mebelRepository.findById(id).orElseThrow();
        mebel.setMebelType(null);
        mebel.setColor(null);
        mebel.setFurnitureBrand(null);
        mebel.setFurnitureType(null);
        mebel.setMaterial(null);
        mebel = mebelRepository.save(mebel);
        mebelRepository.delete(mebel);
        log.debug("Удаление успешно");
    }

    public MebelEntity saveMebel(MiniMebelDto request) {
        log.debug("Запрос на сохранение");
        log.debug(request.toString());

        MebelEntity mebel = MebelEntity.builder()
                .id(request.getId() == null ? null : request.getId())

                .title(request.getTitle())

                .width(request.getWidth())
                .height(request.getHeight())
                .length(request.getLength())

                .productionTimeDays(request.getProductionTimeDays())

                .mebelType(request.getMebelType() == 0 ? null : mebelTypeRepository.findById(request.getMebelType()).orElseThrow())
                .color(request.getColor() == 0 ? null : colorRepository.findById(request.getColor()).orElseThrow())
                .furnitureBrand(request.getFurnitureBrand() == 0 ? null : furnitureBrandRepository.findById(request.getFurnitureBrand()).orElseThrow())
                .furnitureType(request.getFurnitureType() == 0 ? null : furnitureTypeRepository.findById(request.getFurnitureType()).orElseThrow())
                .material(request.getMaterial() == 0 ? null : materialRepository.findById(request.getMaterial()).orElseThrow())
                .build();
        return mebelRepository.save(mebel);
    }
}