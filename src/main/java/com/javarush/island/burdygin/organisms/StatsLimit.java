package com.javarush.island.burdygin.organisms;

public record StatsLimit(double maxWeigh,
                         String icon,
                         int speed,
                         double maxEat,
                         int maxCountPerCell,
                         int organismNumber,
                         String name) {
}
