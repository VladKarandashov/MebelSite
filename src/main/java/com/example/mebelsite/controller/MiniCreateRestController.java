package com.example.mebelsite.controller;

import com.example.mebelsite.model.dto.CreateResponse;
import com.example.mebelsite.service.MiniCreateService;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miniCreate")
@RequiredArgsConstructor
public class MiniCreateRestController {

    private final MiniCreateService miniCreateService;

    @PostMapping("/mebelType")
    public CreateResponse mebelType(@RequestBody CreateRequest request) {
        return miniCreateService.miniCreate(request.getTitle(), "mebelType");
    }

    @PostMapping("/color")
    public CreateResponse color(@RequestBody CreateRequest request) {
        return miniCreateService.miniCreate(request.getTitle(), "color");
    }

    @PostMapping("/furnitureBrand")
    public CreateResponse furnitureBrand(@RequestBody CreateRequest request) {
        return miniCreateService.miniCreate(request.getTitle(), "furnitureBrand");
    }

    @PostMapping("/furnitureType")
    public CreateResponse furnitureType(@RequestBody CreateRequest request) {
        return miniCreateService.miniCreate(request.getTitle(), "furnitureType");
    }

    @PostMapping("/material")
    public CreateResponse material(@RequestBody CreateRequest request) {
        return miniCreateService.miniCreate(request.getTitle(), "material");
    }

    @Data
    @ToString
    @NoArgsConstructor
    private static class CreateRequest {
        private String title;
    }
}