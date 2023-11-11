package com.example.mebelsite.service;

import com.example.mebelsite.model.entity.business.*;
import com.example.mebelsite.model.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EditorService {

    private final MebelRepository mebelRepository;
    private final MebelTypeRepository mebelTypeRepository;
    private final ColorRepository colorRepository;
    private final FurnitureBrandRepository furnitureBrandRepository;
    private final FurnitureTypeRepository furnitureTypeRepository;
    private final MaterialRepository materialRepository;

    public Long getFirstMebelId() {
        return mebelRepository.findFirstRowId().orElse(0L);
    }

    public Long getLastMebelId() {
        return mebelRepository.findLastRowId().orElse(0L);
    }

    public Long getPreviousMebelId(Long id) {
        Long prevId = mebelRepository.getPreviousId(id);
        return prevId == null ? getLastMebelId() : prevId;
    }

    public Long getNextMebelId(Long id) {
        Long nextId = mebelRepository.getNextId(id);
        return nextId == null ? getFirstMebelId() : nextId;
    }

    public MebelEntity processMebelEntity(Long id) {
        if (id == 0) {
            return MebelEntity.builder().mebelType(new MebelTypeEntity()).color(new ColorEntity()).furnitureBrand(new FurnitureBrandEntity()).furnitureType(new FurnitureTypeEntity()).material(new MaterialEntity()).build();
        } else {
            var mebelEntity = mebelRepository.findById(id).orElseThrow();
            if (mebelEntity.getMebelType() == null) mebelEntity.setMebelType(new MebelTypeEntity());
            if (mebelEntity.getColor() == null) mebelEntity.setColor(new ColorEntity());
            if (mebelEntity.getFurnitureBrand() == null) mebelEntity.setFurnitureBrand(new FurnitureBrandEntity());
            if (mebelEntity.getFurnitureType() == null) mebelEntity.setFurnitureType(new FurnitureTypeEntity());
            if (mebelEntity.getMaterial() == null) mebelEntity.setMaterial(new MaterialEntity());
            return mebelEntity;
        }
    }

    public List<MebelTypeEntity> getAllMebelTypes() {
        return mebelTypeRepository.findAll().stream().sorted(Comparator.comparing(MebelTypeEntity::getTitle)).collect(Collectors.toList());
    }

    public List<ColorEntity> getAllColors() {
        return colorRepository.findAll().stream().sorted(Comparator.comparing(ColorEntity::getTitle)).collect(Collectors.toList());
    }

    public List<FurnitureBrandEntity> getAllFurnitureBrands() {
        return furnitureBrandRepository.findAll().stream().sorted(Comparator.comparing(FurnitureBrandEntity::getTitle)).collect(Collectors.toList());
    }

    public List<FurnitureTypeEntity> getAllFurnitureTypes() {
        return furnitureTypeRepository.findAll().stream().sorted(Comparator.comparing(FurnitureTypeEntity::getTitle)).collect(Collectors.toList());
    }

    public List<MaterialEntity> getAllMaterials() {
        return materialRepository.findAll().stream().sorted(Comparator.comparing(MaterialEntity::getTitle)).collect(Collectors.toList());
    }
}
