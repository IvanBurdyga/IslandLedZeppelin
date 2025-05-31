package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.api.service.Service;
import com.javarush.island.burdygin.island.Cell;
import com.javarush.island.burdygin.island.Island;
import com.javarush.island.burdygin.organisms.Organism;
import lombok.Getter;

import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Stream;

@Getter
public abstract class AbstractService implements Service {

    private final Island island;

    public AbstractService(Island island) {
        this.island = island;
    }

    protected Stream<HashSet<Organism>> getOrganismSet(Cell cell) {
        cell.getLock().lock();
        try {
            return cell.getOrganismMap()
                    .values()
                    .stream()
                    .filter(Objects::nonNull);
        } finally {
            cell.getLock().unlock();
        }
    }
}
