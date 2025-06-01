package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 1, icon = OrganismIconsConstants.DUCK_ICON, maxSpeed = 4, maxEat = 0.15, countPerCell = 200, animalNumber = 13, name = OrganismNamesConstants.DUCK_NAME)
public class Duck extends Herbivore {

    public Duck(StatsLimit statsLimit) {
        super(statsLimit);
    }
}