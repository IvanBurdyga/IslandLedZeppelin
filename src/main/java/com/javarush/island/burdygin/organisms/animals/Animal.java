package com.javarush.island.burdygin.organisms.animals;

import com.javarush.island.burdygin.organisms.Organism;
import com.javarush.island.burdygin.organisms.StatsLimit;

public abstract class Animal extends Organism {

    protected Animal(StatsLimit statsLimit) {
        super(statsLimit);
    }
}