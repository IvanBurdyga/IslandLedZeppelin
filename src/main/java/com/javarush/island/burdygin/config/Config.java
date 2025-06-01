package com.javarush.island.burdygin.config;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Config {

    private int period;
    private int rows;
    private int cols;
    private int spawnRate;
    private final Map<String, Map<String, Integer>> foodMap = new HashMap<>();
    private static Config instance;

    private Config() {
    }

    public static synchronized Config getInstance() {
        if (instance == null) {
            instance = new Config();
            ConfigReader configReader = new ConfigReader();
            configReader.read(instance);
        }
        return instance;
    }

}