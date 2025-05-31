package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.island.Island;
import com.javarush.island.burdygin.organisms.Organism;

import java.util.HashSet;
import java.util.stream.Stream;

public class SpawnService extends AbstractService {

    Island island;

    public SpawnService(Island island) {
        super(island);
        this.island = island;
    }

    @Override
    public void run() {
        island.getCellStream().forEach(cell -> {
            Stream<HashSet<Organism>> organismSet = getOrganismSet(cell);

            cell.getLock().lock();
            try {
                organismSet.filter(organisms -> organisms.size() > 2)
                        .forEach(organisms -> {
                            Organism organism = organisms.stream().findAny().get();
                            if (organism.canSpawn()) {
                                organisms.add(organism.spawn(island));
                            }
                        });
            } finally {
                cell.getLock().unlock();
            }
        });
    }

}