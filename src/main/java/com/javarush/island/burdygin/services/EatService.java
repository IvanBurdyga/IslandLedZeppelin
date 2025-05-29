package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.island.Island;

import java.util.Collection;


public class EatService extends AbstractService {

    Island island;

    public EatService(Island island) {
        super(island);
        this.island = island;
    }


    @Override
    public void run() {
        island.getCellStream().forEach(cell -> {
            cell.getLock().lock();
            try {
                cell.getOrganismMap()
                        .values()
                        .forEach(organisms -> {
                            if (!organisms.isEmpty()){
                                organisms.forEach(organism -> organism.eat(cell));
                            }
                        });
            } finally {
                cell.getLock().unlock();
            }
        });
    }
}

