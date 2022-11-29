package ru.job4j;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Kitchen {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private List<Order> orders = new ArrayList<>();
}