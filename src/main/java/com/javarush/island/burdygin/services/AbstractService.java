package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.api.service.Service;
import com.javarush.island.burdygin.island.Cell;
import com.javarush.island.burdygin.island.Island;
import com.javarush.island.burdygin.organisms.Organism;
import lombok.Getter;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Getter
public abstract class AbstractService implements Service {

    private final Island island;

    public AbstractService(Island island) {
        this.island = island;
    }

//    public void process(Cell cell, Consumer<? super Organism> action) {
//        getOrganismSet(cell).forEach(action);


    protected void getOrganismSet(Cell cell, Consumer<? super Organism> action) {
//        cell.getLock().lock();
//        try {
//            cell.getOrganismMap()
//                    .values()
//                    .stream()
//                    .flatMap(Collection::stream)
//                    .forEach(action);
//        } finally {
//            cell.getLock().unlock();
//        }
    }
}
