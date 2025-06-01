package com.javarush.island.burdygin.organisms.animals.predators;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 50, icon = OrganismIconsConstants.WOLF_ICON, maxSpeed = 3, maxEat = 8, countPerCell = 30, animalNumber = 0, name = OrganismNamesConstants.WOLF_NAME)
public class Wolf extends Predator {

    public Wolf(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
