package com.javarush.island.burdygin.init;

import com.javarush.island.burdygin.api.annotation.Stats;
import com.javarush.island.burdygin.organisms.StatsLimit;

public class AnnotationProcessor {

    public String getAnimalName(Class<?> aClass){
        Stats annotation = readStatsAnnotation(aClass);
        return annotation.name();
    }

    public StatsLimit getStatsLimitFromAnnotation(Class<?> aClass){
        Stats annotation = readStatsAnnotation(aClass);
        StatsLimit statsLimit = null;
        if (annotation != null){
            statsLimit = new StatsLimit(annotation.maxWeigh(),
                    annotation.icon(),
                    annotation.maxSpeed(),
                    annotation.maxEat(),
                    annotation.countPerCell(),
                    annotation.animalNumber(),
                    annotation.name());
        }
        return statsLimit;
    }

    private Stats readStatsAnnotation(Class<?> aClass){
        Stats annotation = null;
        if(aClass.isAnnotationPresent(Stats.class)){
            annotation = aClass.getAnnotation(Stats.class);
        }
        return annotation;
    }
}
