package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 0.05, icon = OrganismIconsConstants.MOUSE_ICON, maxSpeed = 1, maxEat = 0.01, countPerCell = 500, animalNumber = 8, name = OrganismNamesConstants.MOUSE_NAME)
public class Mouse extends Herbivore {
    public Mouse(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
