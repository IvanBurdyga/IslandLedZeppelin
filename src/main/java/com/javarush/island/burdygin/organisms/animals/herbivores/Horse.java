package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 400, maxFlockSize = 5, maxSpeed = 4, maxEat = 60, countPerCell = 20, animalNumber = 5, name = "Юлий")
public class Horse extends Herbivore{
    public Horse(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
