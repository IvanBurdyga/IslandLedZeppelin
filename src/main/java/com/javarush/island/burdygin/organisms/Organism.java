package com.javarush.island.burdygin.organisms;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Organism implements Cloneable {

    private boolean isDead = false;
    private double weigh;
    @Setter
    private int flockSize;
    private int countPerCell;
    private final StatsLimit statsLimit;

    public Organism(StatsLimit statsLimit) {
        this.statsLimit = statsLimit;
    }

    private void spawn(){}

    @Override
    public Organism clone() {

        return this;
    }
}
