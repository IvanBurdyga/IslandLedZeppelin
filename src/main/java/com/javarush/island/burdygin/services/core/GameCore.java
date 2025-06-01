package com.javarush.island.burdygin.services.core;

import com.javarush.island.burdygin.config.Config;
import com.javarush.island.burdygin.exception.GameException;
import com.javarush.island.burdygin.services.AbstractService;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameCore {

    private final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private final int DELAY = Config.getInstance().getPeriod();
    private final List<AbstractService> services;
    private ScheduledExecutorService executorService;

    public GameCore(List<AbstractService> services) {
        this.services = services;
    }

    public void gameRun() {
        try {
            executorService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
            services.forEach(service -> executorService.scheduleWithFixedDelay(service, DELAY, DELAY, TimeUnit.MILLISECONDS));
        } catch (GameException e) {
            System.err.println(e.getMessage());
        }
    }
}