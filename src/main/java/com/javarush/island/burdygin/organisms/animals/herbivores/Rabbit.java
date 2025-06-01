package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 2, icon = OrganismIconsConstants.RABBIT_ICON, maxSpeed = 2, maxEat = 0.45, countPerCell = 150, animalNumber = 7, name = OrganismNamesConstants.RABBIT_NAME)
public class Rabbit extends Herbivore {

    public Rabbit(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
