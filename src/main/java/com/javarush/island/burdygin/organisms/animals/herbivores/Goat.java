package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 60, maxFlockSize = 35, maxSpeed = 3, maxEat = 10, countPerCell = 140, animalNumber = 9, name = "Дереза")
public class Goat extends Herbivore {
    public Goat(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
