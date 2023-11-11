package com.example.mebelsite.controller;

import com.example.mebelsite.model.dto.MiniMebelDto;
import com.example.mebelsite.model.entity.business.MebelEntity;
import com.example.mebelsite.service.MebelService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mebel")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MebelController {

    private final MebelService mebelService;

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteRequest request) {
        Long id = request.getId();
        mebelService.deleteMebel(id);
    }

    @PostMapping("/save")
    public MebelEntity save(@Valid @RequestBody MiniMebelDto request) {
        return mebelService.saveMebel(request);
    }

    @Data
    private static class DeleteRequest {
        Long id;
    }
}