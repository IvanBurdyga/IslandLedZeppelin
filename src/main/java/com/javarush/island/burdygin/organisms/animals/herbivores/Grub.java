package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.api.constants.OrganismIconsConstants;
import com.javarush.island.burdygin.api.constants.OrganismNamesConstants;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 0.01, icon = OrganismIconsConstants.GRUB_ICON, maxSpeed = 0, maxEat = 0, countPerCell = 1000, animalNumber = 14, name = OrganismNamesConstants.GRUB_NAME)
public class Grub extends Herbivore{
    public Grub(StatsLimit statsLimit) {
        super(statsLimit);
    }
}
