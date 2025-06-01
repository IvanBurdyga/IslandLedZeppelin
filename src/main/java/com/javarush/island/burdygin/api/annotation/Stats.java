package com.javarush.island.burdygin.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Stats {
    double maxWeigh();

    String icon();

    int maxSpeed();

    double maxEat();

    int countPerCell();

    int animalNumber();

    String name();
}
