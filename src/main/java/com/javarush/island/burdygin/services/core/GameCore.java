package com.javarush.island.burdygin.services.core;

import com.javarush.island.burdygin.api.service.Service;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameCore {
    @Getter
    private final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private final List<Service> services;

    public GameCore(List<Service> services) {
        this.services = services;
    }

    @SneakyThrows
    public void gameRun() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        services.forEach(service -> executorService.scheduleWithFixedDelay(service, 500, 500, TimeUnit.MILLISECONDS));
    }

}
