package ru.job4j;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Card {
    @EqualsAndHashCode.Include
    private int id;
    private String cardNumber;
    private boolean actual;
}
