package com.javarush.island.burdygin.organisms.plants;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.Organism;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 1, icon = OrganismIconsConstants.GRASS_ICON, maxSpeed = 0, maxEat = 0, countPerCell = 200, animalNumber = 15, name = OrganismNamesConstants.GRASS_NAME)
public class Grass extends Organism {

    public Grass(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
