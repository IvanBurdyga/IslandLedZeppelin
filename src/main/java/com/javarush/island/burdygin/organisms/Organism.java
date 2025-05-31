package com.javarush.island.burdygin.organisms;

import com.javarush.island.burdygin.config.Config;
import com.javarush.island.burdygin.exception.GameException;
import com.javarush.island.burdygin.island.Cell;
import com.javarush.island.burdygin.island.Island;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organism implements Cloneable {

    private final StatsLimit statsLimit;
    private final String type = this.getClass().getSimpleName();

    public Organism(StatsLimit statsLimit) {
        this.statsLimit = statsLimit;
    }

    @Override
    public Organism clone() {
        Organism cloned;
        try {
            cloned = (Organism) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new GameException(e, "clone operation failed");
        }
        return cloned;
    }

    public void safeEat(Cell cell) {
        cell.getLock().lock();
        try {
            AtomicBoolean isSaturation = new AtomicBoolean(false);
            AtomicInteger eaten = new AtomicInteger(0);
            cell.getOrganismMap().values().stream()
                    .filter(Objects::nonNull)
                    .forEach(organismHashSet -> organismHashSet.stream()
                            .findAny()
                            .ifPresent(organism -> {
                        if (canEat(organism) && !isSaturation.get()) {
                            eaten.set((int) (eaten.get() + organism.statsLimit.maxWeigh()));
                            if (statsLimit.maxEat() <= eaten.get()) {
                                isSaturation.set(true);
                                organismHashSet.remove(organism);
                            }
                        }
                    }));
        } finally {
            cell.getLock().unlock();
        }
    }

    private boolean canEat(Organism prey) {
        Map<String, Map<String, Integer>> foodMap = Config.getInstance().getFoodMap();
        Map<String, Integer> stringIntegerMap = foodMap.get(statsLimit.name());//todo
        return (!stringIntegerMap.isEmpty()
                && stringIntegerMap.get(prey.statsLimit.name()) != null
                && getPercent() <= stringIntegerMap.get(prey.statsLimit.name()));
    }


    public Organism spawn(Island island) {
        return island.getOrganismsSamples().get(getStatsLimit().name()).clone();
    }

    public int getPercent() {
        return ThreadLocalRandom.current().nextInt(1, 101);
    }

    public boolean canSpawn() {
        return Config.getInstance().getSpawnRate() <= getPercent();
    }

    public void move(Cell cell) {
        Cell nextCell = cell.getNextCell(ThreadLocalRandom.current());
        if (safeAdd(nextCell)) {
            safeDelete(cell);
        } else {
            safeDelete(nextCell);
        }
    }

    private boolean safeAdd(Cell nextCell) {
        nextCell.getLock().lock();
        try {
            return nextCell.getOrganismMap().containsKey(getType())
                    && nextCell.getOrganismMap().get(getType()).size()>statsLimit.maxCountPerCell()
                    && nextCell.getOrganismMap().get(getType()).add(this);
        }finally {
            nextCell.getLock().unlock();
        }
    }

    private void safeDelete(Cell cell) {
        cell.getLock().lock();
        try {
            cell.getOrganismMap().get(getType()).remove(this);
        }finally {
            cell.getLock().unlock();
        }
    }
}
