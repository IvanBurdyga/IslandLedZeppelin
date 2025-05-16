package com.javarush.island.burdygin.services.core;

import com.javarush.island.burdygin.init.AnnotationProcessor;
import com.javarush.island.burdygin.init.IslandCreator;
import com.javarush.island.burdygin.island.Island;

public class GameCore {
    private final Island island = new Island(new IslandCreator(new AnnotationProcessor()));
    public static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
}
