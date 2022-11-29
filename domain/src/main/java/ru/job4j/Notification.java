package ru.job4j;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notification {
    @EqualsAndHashCode.Include
    private int id;
    private String message;
}