package com.javarush.island.burdygin.organisms;

import lombok.Getter;

@Getter
public class StatsLimit {
    private final double maxWeigh;
    private final int maxFlockSize;
    private final int speed;
    private final double maxEat;
    private final int maxCountPerCell;
    private final int animalNumber;
    private final String name;

    public StatsLimit(double maxWeigh, int maxFlockSize, int speed, double maxEat, int maxCountPerCell, int animalNumber, String name) {
        this.maxWeigh = maxWeigh;
        this.maxFlockSize = maxFlockSize;
        this.speed = speed;
        this.maxEat = maxEat;
        this.maxCountPerCell = maxCountPerCell;
        this.animalNumber = animalNumber;
        this.name = name;
    }
}
