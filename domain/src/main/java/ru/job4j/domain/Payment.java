package ru.job4j.domain;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Payment {
    @EqualsAndHashCode.Include
    private int id;
    private String method;
    private boolean successful;
    private Timestamp paymentTime;
    private Order order;
}
