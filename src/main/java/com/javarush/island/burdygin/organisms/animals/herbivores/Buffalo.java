package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 700, icon = OrganismIconsConstants.BUFFALO_ICON, maxSpeed = 3, maxEat = 100, countPerCell = 10, animalNumber = 12, name = OrganismNamesConstants.BUFFALO_NAME)
public class Buffalo extends Herbivore {

    public Buffalo(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
