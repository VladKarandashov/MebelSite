package com.example.mebelsite.view;

import com.example.mebelsite.service.EditorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editor")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class EditorController {

    private final EditorService editorService;


    @GetMapping
    public String show() {
        return "redirect:/editor/" + editorService.getFirstMebelId();
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable Long id, Model model) {

        Long firstFilmId = editorService.getFirstMebelId();
        Long lastFilmId = editorService.getLastMebelId();
        model.addAttribute("firstId", firstFilmId);
        model.addAttribute("lastId", lastFilmId);

        var previousId = editorService.getPreviousMebelId(id);
        var nextId = editorService.getNextMebelId(id);
        model.addAttribute("prevId", previousId);
        model.addAttribute("nextId", nextId);

        var mebelEntity = editorService.processMebelEntity(id);
        model.addAttribute("mebel", mebelEntity);

        model.addAttribute("mebelTypes", editorService.getAllMebelTypes());
        model.addAttribute("colors", editorService.getAllColors());
        model.addAttribute("furnitureBrands", editorService.getAllFurnitureBrands());
        model.addAttribute("furnitureTypes", editorService.getAllFurnitureTypes());
        model.addAttribute("materials", editorService.getAllMaterials());

        return "/db/editor";
    }
}
