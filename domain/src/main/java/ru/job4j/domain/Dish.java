package ru.job4j.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dish {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String category;
    private String description;
    private double price;
}