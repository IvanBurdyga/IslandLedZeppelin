package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.island.Cell;
import com.javarush.island.burdygin.organisms.Organism;
import lombok.Getter;

import java.util.Collection;
import java.util.Set;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public abstract class AbstractService implements Runnable {

    protected Set<Organism> getOrganismSet(Cell cell) {
        cell.getLock().lock();
        try {
            return cell.getOrganismMap()
                    .values()
                    .stream()
                    .filter(Objects::nonNull)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toSet());
        } finally {
            cell.getLock().unlock();
        }
    }
}
