package com.example.mebelsite.view;

import com.example.mebelsite.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping
    public String show(@RequestParam(required = false, defaultValue = "0") Long mebelType,
                       @RequestParam(required = false, defaultValue = "0") Long color,
                       @RequestParam(required = false, defaultValue = "0") Long furnitureType,
                       Model model) {
        model.addAttribute("idMebelType", mebelType);
        model.addAttribute("idColor", color);
        model.addAttribute("idFurnitureType", furnitureType);

        var mebelList = searchService.getMebelList(mebelType, color, furnitureType);
        model.addAttribute("mebelList", mebelList);

        var searchDto = searchService.getSearchDto(mebelList);
        model.addAttribute("mebelTypes", searchDto.getMebelTypes());
        model.addAttribute("colors", searchDto.getColors());
        model.addAttribute("furnitureTypes", searchDto.getFurnitureTypes());

        return "db/search";
    }
}