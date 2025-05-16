package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 700, maxFlockSize = 5, maxSpeed = 3, maxEat = 100, countPerCell = 10, animalNumber = 12, name = "Буйволсон")
public class Buffalo extends Herbivore{

    public Buffalo(StatsLimit statsLimit) {
        super(statsLimit);
    }


}
