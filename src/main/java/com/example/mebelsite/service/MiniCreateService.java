package com.example.mebelsite.service;

import com.example.mebelsite.model.dto.CreateResponse;
import com.example.mebelsite.model.dto.Item;
import com.example.mebelsite.model.entity.business.*;
import com.example.mebelsite.model.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MiniCreateService {

    private final MebelTypeRepository mebelTypeRepository;
    private final ColorRepository colorRepository;
    private final FurnitureBrandRepository furnitureBrandRepository;
    private final FurnitureTypeRepository furnitureTypeRepository;
    private final MaterialRepository materialRepository;

    public CreateResponse miniCreate(@NonNull String title, String obj) {
        switch (obj) {
            case "mebelType" -> {
                return createMebelType(title);
            }
            case "color" -> {
                return createColor(title);
            }
            case "furnitureBrand" -> {
                return createFurnitureBrand(title);
            }
            case "furnitureType" -> {
                return createFurnitureType(title);
            }
            case "material" -> {
                return createMaterial(title);
            }
        }
        return null;
    }

    private CreateResponse createMebelType(String title) {
        assert mebelTypeRepository.existsByTitle(title);
        var newObj = mebelTypeRepository.save(new MebelTypeEntity(title));
        var item = new Item(newObj.getId(), newObj.getTitle());
        List<Item> items = mebelTypeRepository.findAll()
                .stream()
                .map(el -> new Item(el.getId(), el.getTitle()))
                .sorted(Comparator.comparing(Item::getTitle))
                .toList();
        return new CreateResponse(items, item);
    }

    private CreateResponse createColor(String title) {
        assert colorRepository.existsByTitle(title);
        var newObj = colorRepository.save(new ColorEntity(title));
        var item = new Item(newObj.getId(), newObj.getTitle());
        List<Item> items = colorRepository.findAll()
                .stream()
                .map(el -> new Item(el.getId(), el.getTitle()))
                .sorted(Comparator.comparing(Item::getTitle))
                .toList();
        return new CreateResponse(items, item);
    }

    private CreateResponse createFurnitureBrand(String title) {
        assert furnitureBrandRepository.existsByTitle(title);
        var newObj = furnitureBrandRepository.save(new FurnitureBrandEntity(title));
        var item = new Item(newObj.getId(), newObj.getTitle());
        List<Item> items = furnitureBrandRepository.findAll()
                .stream()
                .map(el -> new Item(el.getId(), el.getTitle()))
                .sorted(Comparator.comparing(Item::getTitle))
                .toList();
        return new CreateResponse(items, item);
    }

    private CreateResponse createFurnitureType(String title) {
        assert furnitureTypeRepository.existsByTitle(title);
        var newObj = furnitureTypeRepository.save(new FurnitureTypeEntity(title));
        var item = new Item(newObj.getId(), newObj.getTitle());
        List<Item> items = furnitureTypeRepository.findAll()
                .stream()
                .map(el -> new Item(el.getId(), el.getTitle()))
                .sorted(Comparator.comparing(Item::getTitle))
                .toList();
        return new CreateResponse(items, item);
    }

    private CreateResponse createMaterial(String title) {
        assert materialRepository.existsByTitle(title);
        var newObj = materialRepository.save(new MaterialEntity(title));
        var item = new Item(newObj.getId(), newObj.getTitle());
        List<Item> items = materialRepository.findAll()
                .stream()
                .map(el -> new Item(el.getId(), el.getTitle()))
                .sorted(Comparator.comparing(Item::getTitle))
                .toList();
        return new CreateResponse(items, item);
    }
}