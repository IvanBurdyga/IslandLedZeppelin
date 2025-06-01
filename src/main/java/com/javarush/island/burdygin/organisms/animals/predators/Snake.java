package com.javarush.island.burdygin.organisms.animals.predators;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 15, icon = OrganismIconsConstants.SNAKE_ICON, maxSpeed = 1, maxEat = 3, countPerCell = 30, animalNumber = 1, name = OrganismNamesConstants.SNAKE_NAME)
public class Snake extends Predator {

    public Snake(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
