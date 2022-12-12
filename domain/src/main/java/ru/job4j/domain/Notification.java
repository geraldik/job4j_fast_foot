package ru.job4j.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Notification {
    @EqualsAndHashCode.Include
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
}