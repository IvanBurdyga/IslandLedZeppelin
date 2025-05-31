package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.island.Island;


public class EatService extends AbstractService {

    Island island;

    public EatService(Island island) {
        super(island);
        this.island = island;
    }

    @Override
    public void run() {
       island.getCellStream()
               .forEach(cell -> getOrganismSet(cell)
                       .forEach(organisms -> organisms
                               .forEach(organism -> organism.safeEat(cell))));
    }
}

