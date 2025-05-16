package com.javarush.island.burdygin.island;

import com.javarush.island.burdygin.organisms.Organism;
import com.javarush.island.burdygin.init.IslandCreator;
import lombok.Getter;

import java.util.Map;

@Getter
public class Island {

    private final int COLS = 100;
    private final int ROWS = 20;
    private final Cell[][] area;
    private final Map<String, Organism> organismsSamples;

    public Island(IslandCreator islandCreator) {
        organismsSamples = islandCreator.organismsSamplesInitialization();
        area = islandCreator.mapInitialization(ROWS,COLS, organismsSamples);

    }
}
