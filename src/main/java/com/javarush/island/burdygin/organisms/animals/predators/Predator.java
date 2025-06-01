package com.javarush.island.burdygin.organisms.animals.predators;

import com.javarush.island.burdygin.organisms.StatsLimit;
import com.javarush.island.burdygin.organisms.animals.Animal;

public abstract class Predator extends Animal {

    public Predator(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
