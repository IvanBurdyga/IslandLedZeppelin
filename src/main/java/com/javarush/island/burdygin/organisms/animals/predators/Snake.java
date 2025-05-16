package com.javarush.island.burdygin.organisms.animals.predators;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 15, maxFlockSize = 10, maxSpeed = 1, maxEat = 3, countPerCell = 30, animalNumber = 1, name = "Удав")
public class Snake extends Predator{
    public Snake(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
