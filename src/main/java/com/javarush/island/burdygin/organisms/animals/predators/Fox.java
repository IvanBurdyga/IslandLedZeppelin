package com.javarush.island.burdygin.organisms.animals.predators;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 8, icon = OrganismIconsConstants.FOX_ICON, maxSpeed = 2, maxEat = 2, countPerCell = 30, animalNumber = 2, name = OrganismNamesConstants.FOX_NAME)
public class Fox extends Predator{
    public Fox(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
