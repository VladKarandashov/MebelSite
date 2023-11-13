package com.example.mebelsite.view;

import com.example.mebelsite.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final SearchService searchService;

    @GetMapping
    public String show(Model model){

        var mebelType = 0L;
        var color = 0L;
        var furnitureType = 0L;

        model.addAttribute("idMebelType", mebelType);
        model.addAttribute("idColor", color);
        model.addAttribute("idFurnitureType", furnitureType);

        var mebelList = searchService.getMebelList(mebelType, color, furnitureType);
        model.addAttribute("mebelList", mebelList);

        var searchDto = searchService.getSearchDto(mebelList);
        model.addAttribute("mebelTypes", searchDto.getMebelTypes());
        model.addAttribute("colors", searchDto.getColors());
        model.addAttribute("furnitureTypes", searchDto.getFurnitureTypes());

        return "site/api";
    }
}