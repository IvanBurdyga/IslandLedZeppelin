package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.island.Island;


public class EatService extends AbstractService {

    private final Island island;

    public EatService(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        island.getCellStream().forEach(cell -> getOrganismSet(cell).forEach(organism -> organism.safeEat(cell)));
    }
}

