package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 2, maxFlockSize = 50, maxSpeed = 2, maxEat = 0.45, countPerCell = 150, animalNumber = 7, name = "Джуди")
public class Rabbit extends Herbivore{
    public Rabbit(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
