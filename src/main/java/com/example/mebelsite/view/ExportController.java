package com.example.mebelsite.view;

import com.example.mebelsite.service.ExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/export")
@RequiredArgsConstructor
public class ExportController {

    private final ExportService exportService;

    @GetMapping
    public String export(Model model) {
        model.addAttribute("mebelList", exportService.getAllMebelEntity());
        return "db/export";
    }

    @GetMapping("/XML")
    public String xml(Model model) {
        model.addAttribute("mebelList", exportService.getAllMebelEntity());
        return "db/exportXML";
    }
}
