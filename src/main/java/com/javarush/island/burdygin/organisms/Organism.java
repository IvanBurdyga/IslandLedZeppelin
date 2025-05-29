package com.javarush.island.burdygin.organisms;

import com.javarush.island.burdygin.config.Config;
import com.javarush.island.burdygin.exception.GameException;
import com.javarush.island.burdygin.island.Cell;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organism implements Cloneable {

    @Setter
    private boolean isDead = false;
    private double weigh;//todo
    @Setter
    private int flockSize;
    @Setter
    private int countPerCell;
    private final StatsLimit statsLimit;

    public Organism(StatsLimit statsLimit) {
        this.statsLimit = statsLimit;
    }

    @Override
    public Organism clone() {
        Organism cloned = null;
        try {
            cloned = (Organism) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new GameException(e, "clone operation failed");
        }
        return cloned;
    }

    public void eat(Cell cell) {
        cell.getLock().lock();
        try {
            AtomicBoolean isSaturation = new AtomicBoolean(false);
            AtomicInteger eaten = new AtomicInteger(0);
            for (HashSet<Organism> organismHashSet : cell.getOrganismMap().values()) {
                if (!organismHashSet.isEmpty()) {
                    Organism organism = organismHashSet.stream().findAny().get();
                    if (this.canEat(organism) && !isSaturation.get()) {
                        eaten.set((int) (eaten.get() + organism.statsLimit.maxWeigh()));
                        if (this.statsLimit.maxEat() <= eaten.get()) {
                            isSaturation.set(true);
                        }
                        organism.setDead(true);
                    }
                }
            }
            cell.getOrganismMap().values().forEach(organismHashSet -> {
               if (!organismHashSet.isEmpty()){
                   organismHashSet.forEach(organism -> {
                       if (organism.isDead()){
                           organismHashSet.remove(organism);
                       }
                   });
               }
            });
        } finally {
            cell.getLock().unlock();
        }
    }


    private boolean canEat(Organism prey) {
        boolean canEat = false;
        Map<String, Map<String, Integer>> foodMap = Config.getInstance().getFoodMap();
        Map<String, Integer> stringIntegerMap = foodMap.get("Wolf");//todo
        if (!stringIntegerMap.isEmpty()){
            int canEatPercents = ThreadLocalRandom.current().nextInt(1,101);
            if (stringIntegerMap.get(prey.statsLimit.name()) != null){
                int test = stringIntegerMap.get(prey.statsLimit.name());
                if (canEatPercents <= test) {
                    canEat = true;
                }
            }

        }
        return canEat;
    }

    public void spawn(Organism organism) {
    }
}
