package com.javarush.island.burdygin.organisms.animals.predators;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 6, icon = OrganismIconsConstants.EAGLE_ICON, maxSpeed = 3, maxEat = 1, countPerCell = 20, animalNumber = 4, name = OrganismNamesConstants.EAGLE_NAME)
public class Eagle extends Predator {

    public Eagle(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
