package ru.job4j.admin.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.admin.service.DishAPIService;
import ru.job4j.domain.Dish;

@Controller
@AllArgsConstructor
public class AdminController {

    private final DishAPIService service;

    @GetMapping("/dish")
    public String posts(Model model) {
        model.addAttribute("dishes", service.findAll());
        return "dish";
    }

    @GetMapping("/formUpdateDish/{dishId}")
    public String formUpdateDish(Model model, @PathVariable("dishId") int id) {
        model.addAttribute("dish", service.findById(id));
        model.addAttribute("categories", service.findAllCategories());
        return "updateDish";
    }

    @PostMapping("/updateDish")
    public String updatePost(@ModelAttribute Dish dish) {
        service.update(dish);
        return "redirect:/dish";
    }
}
