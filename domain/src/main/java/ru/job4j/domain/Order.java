package ru.job4j.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "order_dish",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "dish_id") }
    )
    private Set<Dish> dishes = new HashSet<>();
    @Enumerated(STRING)
    private Status status;
}
