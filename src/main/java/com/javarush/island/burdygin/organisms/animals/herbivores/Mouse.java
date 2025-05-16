package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 0.05, maxFlockSize = 100, maxSpeed = 1, maxEat = 0.01, countPerCell = 500, animalNumber = 8, name = "Джерри")
public class Mouse extends Herbivore {
    public Mouse(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
