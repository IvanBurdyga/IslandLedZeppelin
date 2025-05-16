package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 300, maxFlockSize = 5, maxSpeed = 4, maxEat = 50, countPerCell = 20, animalNumber = 6, name = "Бэмби")
public class Deer extends Herbivore{
    public Deer(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
