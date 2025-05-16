package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 400, maxFlockSize = 10, maxSpeed = 2, maxEat = 50, countPerCell = 50, animalNumber = 11, name = "Пумба")
public class Hog extends Herbivore {
    public Hog(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
