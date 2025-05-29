package com.javarush.island.burdygin.island;

import com.javarush.island.burdygin.organisms.Organism;
import com.javarush.island.burdygin.init.IslandCreator;

import java.util.*;
import java.util.stream.Stream;

public class Island {

    private final int COLS = 100;
    private final int ROWS = 20;
    private final Cell[][] area;
    private final Map<String, Organism> organismsSamples;

    public Island(IslandCreator islandCreator) {
        organismsSamples = islandCreator.organismsSamplesInitialization();
        area = islandCreator.mapInitialization(ROWS, COLS, organismsSamples);
    }

    public Map<String, Integer> safeUpdateStatistic() {
        Map<String, Integer> newStatistic = new LinkedHashMap<>();
        getCellStream().forEach(cell -> {
            cell.getLock().lock();
            try {
                cell.getOrganismMap().forEach((name, organisms) -> {
                    int i = 0;
                    if (newStatistic.containsKey(name)) {
                        i = newStatistic.get(name);
                    }
                    if (!organisms.isEmpty()) {
                        i = i + organisms.size();
                    }
                    newStatistic.put(name, i);
                });
            } finally {
                cell.getLock().unlock();
            }
        });
        return newStatistic;
    }

    public Stream<Cell> getCellStream() {
        return getRowStream()
                .flatMap(Arrays::stream);
    }

    public Stream<Cell[]> getRowStream() {
        return Arrays.stream(area);
    }

}
