package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 70, icon = OrganismIconsConstants.SHEEP_ICON, maxSpeed = 3, maxEat = 15, countPerCell = 140, animalNumber = 10, name = OrganismNamesConstants.SHEEP_NAME)
public class Sheep extends Herbivore {

    public Sheep(StatsLimit statsLimit) {
        super(statsLimit);
    }
}