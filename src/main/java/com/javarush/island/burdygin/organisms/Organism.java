package com.javarush.island.burdygin.organisms;

import com.javarush.island.burdygin.config.Config;
import com.javarush.island.burdygin.exception.GameException;
import com.javarush.island.burdygin.island.Cell;
import com.javarush.island.burdygin.island.Island;
import com.javarush.island.burdygin.organisms.plants.Grass;
import lombok.Getter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organism implements Cloneable {

    private final StatsLimit statsLimit;
    private final String organismTypeName = this.getClass().getSimpleName();

    public Organism(StatsLimit statsLimit) {
        this.statsLimit = statsLimit;
    }

    @Override
    public Organism clone() {
        Organism cloned;
        try {
            cloned = (Organism) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new GameException("clone operation failed");
        }
        return cloned;
    }

    public void safeEat(Cell cell) {
        cell.getLock().lock();
        try {
            AtomicBoolean isSaturation = new AtomicBoolean(false);
            AtomicInteger eaten = new AtomicInteger(0);
            cell.getOrganismMap()
                    .values()
                    .stream()
                    .filter(Objects::nonNull)
                    .forEach(organismHashSet -> organismHashSet.stream()
                            .findAny()
                            .ifPresent(organism -> {
                                if (canEat(organism) && !isSaturation.get()) {
                                    eaten.set((int) (eaten.get() + organism.statsLimit.maxWeigh()));
                                    organismHashSet.remove(organism);
                                    if (statsLimit.maxEat() <= eaten.get()) {
                                        isSaturation.set(true);
                                    }
                                }
                            }));
        } finally {
            cell.getLock().unlock();
        }
    }

    private boolean canEat(Organism prey) {
        Map<String, Map<String, Integer>> foodMap = Config.getInstance().getFoodMap();
        Map<String, Integer> stringIntegerMap = foodMap.get(getOrganismTypeName());
        return !stringIntegerMap.isEmpty()
                && stringIntegerMap.get(prey.getOrganismTypeName()) != null
                && getPercent() <= stringIntegerMap.get(prey.getOrganismTypeName());
    }

    public int getPercent() {
        return ThreadLocalRandom.current().nextInt(1, 101);
    }

    public boolean canSpawn() {
        return Config.getInstance().getSpawnRate() <= getPercent();
    }

    public void move(Cell cell) {
        if (!canMove()) {
            return;
        }
        Cell nextCell = cell.getNextCell(ThreadLocalRandom.current(), getStatsLimit().speed());
        safeMove(cell, nextCell);
    }

    public void safeMove(Cell cell, Cell nextCell) {
        if (safeAdd(nextCell)) {
            if (!safeDelete(cell)) {
                safeDelete(nextCell);
            }
        }
    }

    private boolean canMove() {
        return !(this instanceof Grass);
    }

    private boolean safeAdd(Cell cell) {
        cell.getLock().lock();
        try {
            HashSet<Organism> organismSet = cell.getOrganismMap().get(getOrganismTypeName());
            return organismSet.size() < statsLimit.maxCountPerCell()
                    && organismSet.add(this);
        } finally {
            cell.getLock().unlock();
        }
    }

    private boolean safeDelete(Cell cell) {
        cell.getLock().lock();
        try {
            return cell.getOrganismMap()
                    .get(getOrganismTypeName())
                    .remove(this);
        } finally {
            cell.getLock().unlock();
        }
    }

    public void spawn(Cell cell) {
        cell.getLock().lock();
        try {
            HashSet<Organism> organisms = cell.getOrganismMap().get(getOrganismTypeName());
            if (organisms.size() > 2 && organisms.size() < getStatsLimit().maxCountPerCell() && canSpawn()) {
                organisms.add(clone());
            }
        } finally {
            cell.getLock().unlock();
        }
    }
}
