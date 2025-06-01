package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 60, icon = OrganismIconsConstants.GOAT_ICON, maxSpeed = 3, maxEat = 10, countPerCell = 140, animalNumber = 9, name = OrganismNamesConstants.GOAT_NAME)
public class Goat extends Herbivore {

    public Goat(StatsLimit statsLimit) {
        super(statsLimit);
    }
}