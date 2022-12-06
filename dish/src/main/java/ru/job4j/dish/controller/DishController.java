package ru.job4j.dish.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.service.CategoryService;
import ru.job4j.dish.service.DishService;
import ru.job4j.domain.Category;
import ru.job4j.domain.Dish;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/dish")
public class DishController {

    private final DishService dishService;
    private final CategoryService simpleCategoryService;

    @PostMapping
    public Dish save(@RequestBody Dish dish) {
        return dishService.addDish(dish);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Dish dish) {
        var category = simpleCategoryService.findById(dish.getCategory().getId());
        dish.setId(id);
        dish.setCategory(category);
        boolean status = dishService.update(dish);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean status = dishService.deleteById(id);
        return ResponseEntity
                .status(status ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .build();
    }

    @GetMapping
    public List<Dish> getAll() {
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    public Dish getById(@PathVariable int id) {
        return dishService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Dish getByName(@PathVariable String name) {
        return dishService.findByName(name);
    }

    @GetMapping("/category")
    public List<Category> getCategories() {
        return simpleCategoryService.findAllCategories();
    }

}
