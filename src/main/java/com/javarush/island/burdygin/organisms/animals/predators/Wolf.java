package com.javarush.island.burdygin.organisms.animals.predators;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 50, maxFlockSize = 10, maxSpeed = 3, maxEat = 8, countPerCell = 30, animalNumber = 0, name = "Акела")
public class Wolf extends Predator{
    public Wolf(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
