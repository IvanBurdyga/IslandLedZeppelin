package com.javarush.island.burdygin.services.core;

import com.javarush.island.burdygin.api.service.Service;
import com.javarush.island.burdygin.island.Island;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameCore {
    @Getter
    private boolean isGameOver;
    private final Island island;
    private final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private final List<Service> services;

    public GameCore(Island island, List<Service> services) {
        this.island = island;
        this.services = services;
    }

    public void gameRun(){
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this::doOneStepGame,0,1, TimeUnit.SECONDS);
    }

    public void doOneStepGame() {
        ExecutorService executorService = Executors.newFixedThreadPool(CORE_POOL_SIZE);
        services.forEach(executorService::submit);
        executorService.shutdown();

    }

}
