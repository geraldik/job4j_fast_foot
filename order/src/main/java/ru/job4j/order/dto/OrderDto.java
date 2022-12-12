package ru.job4j.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.job4j.domain.Dish;
import ru.job4j.domain.Status;

import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto implements Serializable {
    private String name;
    private String description;
    private double price;
    private List<Dish> dishes = new ArrayList<>();
    @Enumerated(STRING)
    private Status status;
}
