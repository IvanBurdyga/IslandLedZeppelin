package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.organisms.StatsLimit;
import com.javarush.island.burdygin.organisms.animals.Animal;

public abstract class Herbivore extends Animal {

    public Herbivore(StatsLimit statsLimit) {
        super(statsLimit);
    }
}