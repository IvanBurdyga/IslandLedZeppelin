package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 0.01, maxFlockSize = 200, maxSpeed = 0, maxEat = 0, countPerCell = 1000, animalNumber = 14, name = "Вупсень и Пупсень")
public class Grub extends Herbivore{
    public Grub(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
