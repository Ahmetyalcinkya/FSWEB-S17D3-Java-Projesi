package com.workintech.s17d3.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Koala {
    private int id;
    private String name;
    private double weight;
    private int sleepHour;
    private Gender gender;
}
