package ru.job4j.domain;

import lombok.*;

import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String description;
    private double price;
    private List<Dish> dishes = new ArrayList<>();
    @Enumerated(STRING)
    private Status status;
}
