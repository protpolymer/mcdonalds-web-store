package ru.itpark.mcdonaldsweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itpark.mcdonaldsweb.service.GoodsService;


@Controller
@RequestMapping("/")
public class GoodsController {
    private GoodsService service;

    public GoodsController(GoodsService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("items", service.getAll());
        return "all";
    }

    @GetMapping("/items/{id}")
    public String getById(@PathVariable int id, Model model) {
        model.addAttribute("item", service.getById(id));
        return "view";
    }
}
