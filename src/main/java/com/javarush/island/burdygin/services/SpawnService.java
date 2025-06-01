package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.island.Island;

public class SpawnService extends AbstractService {

    private final Island island;

    public SpawnService(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        island.getCellStream().forEach(cell -> getOrganismSet(cell).stream().findAny().ifPresent(organism -> organism.spawn(cell)));
    }
}