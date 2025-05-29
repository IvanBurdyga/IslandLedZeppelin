package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 300, icon = OrganismIconsConstants.DEER_ICON, maxSpeed = 4, maxEat = 50, countPerCell = 20, animalNumber = 6, name = OrganismNamesConstants.DEER_NAME)
public class Deer extends Herbivore{
    public Deer(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
