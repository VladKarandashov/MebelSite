package com.example.mebelsite.view;

import com.example.mebelsite.service.StatisticService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticService statisticService;

    @GetMapping
    public String show(Model model) throws JsonProcessingException {

        model.addAttribute("countMebel", statisticService.countMebel());
        model.addAttribute("statistics", statisticService.jsonStatistics());

        return "db/statistics";
    }
}