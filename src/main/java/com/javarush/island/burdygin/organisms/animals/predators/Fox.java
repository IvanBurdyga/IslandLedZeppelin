package com.javarush.island.burdygin.organisms.animals.predators;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 8, maxFlockSize = 10, maxSpeed = 2, maxEat = 2, countPerCell = 30, animalNumber = 2, name = "Ник")
public class Fox extends Predator{
    public Fox(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
