package ru.job4j.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Courier {
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String phoneNumber;
    private Order order;

}
