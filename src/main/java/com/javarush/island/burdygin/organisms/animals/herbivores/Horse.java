package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 400, icon = OrganismIconsConstants.HORSE_ICON, maxSpeed = 4, maxEat = 60, countPerCell = 20, animalNumber = 5, name = OrganismNamesConstants.HORSE_NAME)
public class Horse extends Herbivore {

    public Horse(StatsLimit statsLimit) {
        super(statsLimit);
    }
}