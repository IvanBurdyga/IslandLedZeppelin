package com.javarush.island.burdygin.organisms.animals.herbivores;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.Organism;
import com.javarush.island.burdygin.organisms.StatsLimit;

@Stats(maxWeigh = 1, maxFlockSize = 50, maxSpeed = 4, maxEat = 0.15, countPerCell = 200, animalNumber = 13, name = "Дональд")
public class Duck extends Herbivore{
    public Duck(StatsLimit statsLimit) {
        super(statsLimit);
    }

    @Override
    public void toEat(Organism organism){
        if (organism instanceof Grub){
        } else {
            super.toEat(organism);
        }
    }

    public void toEat(Grub grub){

    }
}
//todo eat grub except herbs