package com.javarush.island.burdygin.organisms.animals.predators;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 6, maxFlockSize = 5, maxSpeed = 3, maxEat = 1, countPerCell = 20, animalNumber = 4, name = "Итан")
public class Eagle extends Predator{
    public Eagle(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
