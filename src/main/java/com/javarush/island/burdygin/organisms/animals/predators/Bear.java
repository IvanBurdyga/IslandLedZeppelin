package com.javarush.island.burdygin.organisms.animals.predators;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 500, maxFlockSize = 1, maxSpeed = 2, maxEat = 80, countPerCell = 5, animalNumber = 3, name = "Фредди")
public class Bear extends Predator{

    public Bear(StatsLimit statsLimit){
        super(statsLimit);
    }

}
