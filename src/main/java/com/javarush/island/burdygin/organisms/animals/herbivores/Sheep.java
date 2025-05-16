package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 70, maxFlockSize = 35, maxSpeed = 3, maxEat = 15, countPerCell = 140, animalNumber = 10, name = "Шон")
public class Sheep extends Herbivore{
    public Sheep(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
