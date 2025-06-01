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
        int cols = Config.getInstance().getCols();
        int rows = Config.getInstance().getRows();
        organismsSamples = islandCreator.organismsSamplesInitialization();
        area = islandCreator.mapInitialization(rows, cols, organismsSamples);
    }

    public Map<String, Integer> safeUpdateStatistic() {
        Map<String, Integer> newStatistic = new LinkedHashMap<>();
        getCellStream().forEach(cell -> {
            cell.getLock().lock();
            try {
                cell.getOrganismMap().values()
                        .stream()
                        .filter(Objects::nonNull)
                        .forEach((organisms) -> {
                            String name = null;
                            if (organisms.stream()
                                    .findAny()
                                    .isPresent()) {
                                name = organisms.stream().findAny().get().getStatsLimit().name();
                            }
                            int i = organisms.size();
                            if (newStatistic.containsKey(name)) {
                                i = i + newStatistic.get(name);
                            }
                            if (name != null){
                                newStatistic.put(name, i);
                            }

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
