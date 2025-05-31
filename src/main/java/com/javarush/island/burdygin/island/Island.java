package com.javarush.island.burdygin.island;

import com.javarush.island.burdygin.config.Config;
import com.javarush.island.burdygin.organisms.Organism;
import com.javarush.island.burdygin.init.IslandCreator;
import lombok.Getter;

import java.util.*;
import java.util.stream.Stream;

public class Island {

    private final Cell[][] area;
    @Getter
    private final Map<String, Organism> organismsSamples;

    public Island(IslandCreator islandCreator) {
        int COLS = Config.getInstance().getCols();
        int ROWS = Config.getInstance().getRows();
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
