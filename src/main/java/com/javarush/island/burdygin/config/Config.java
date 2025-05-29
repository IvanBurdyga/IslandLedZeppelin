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
    private Map<String, Map<String, Integer>> foodMap = new HashMap<>();
    private static final Config instance = new Config();

    private Config() {}

    public static synchronized Config getInstance() {
        ConfigReader configReader = new ConfigReader();
        configReader.read(instance);
        return instance;
    }
}
