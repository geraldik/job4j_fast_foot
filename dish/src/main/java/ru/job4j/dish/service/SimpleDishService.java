package ru.job4j.dish.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dish.repository.DishRepository;
import ru.job4j.domain.Dish;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private final DishRepository repository;

    @Override
    public Dish addDish(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public boolean update(Dish dish) {
        if (!repository.existsById(dish.getId())) {
           return false;
        }
        repository.save(dish);
        return true;
    }

    @Override
    public Dish findByName(String name) {
        var optionalDish = repository.findByName(name);
        if (optionalDish.isEmpty()) {
            throw new NoSuchElementException("There is no such dish with this name");
        }
        return optionalDish.get();
    }

    @Override
    public Dish findById(int id) {
        var optionalDish = repository.findById(id);
        if (optionalDish.isEmpty()) {
            throw new NoSuchElementException("There is no such dish with this id");
        }
        return optionalDish.get();
    }

     @Override
     public List<Dish> findAll() {
        return repository.findAll();
     }

    @Override
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

}

