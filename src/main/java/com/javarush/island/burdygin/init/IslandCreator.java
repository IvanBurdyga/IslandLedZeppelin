package com.javarush.island.burdygin.init;

import com.javarush.island.burdygin.api.constants.ClassPathsConstants;
import com.javarush.island.burdygin.exception.GameException;
import com.javarush.island.burdygin.config.Config;
import com.javarush.island.burdygin.island.Cell;
import com.javarush.island.burdygin.organisms.Organism;

import java.util.*;

public class IslandCreator {

    private final AnnotationProcessor annotationProcessor;


    public IslandCreator(AnnotationProcessor annotationProcessor) {
        this.annotationProcessor = annotationProcessor;
    }

    public Cell[][] mapInitialization(int rows, int cols, Map<String, Organism> organismsSamples) {
        Cell[][] area = new Cell[rows][cols];
        for (int row = 0; row < area.length; row++) {
            for (int col = 0; col < area[row].length; col++) {
                area[row][col] = new Cell(randomOrganismCellInitialization(organismsSamples));
            }
        }
        for (int row = 0; row < area.length; row++) {
            for (int col = 0; col < area[row].length; col++) {
                area[row][col].updateNextCells(area, row, col);
            }
        }
        return area;
    }

    public Map<String, Organism> organismsSamplesInitialization() {
        Map<String, Organism> organismsSamples = new HashMap<>();
        Set<String> organismSet = Config.getInstance().getFoodMap().keySet();
        for (String s : organismSet) {
            try {
                Class<?> aClass = null;
                switch (s.toLowerCase()) {
                    case "wolf", "bear", "eagle", "fox", "snake" ->
                            aClass = Class.forName(ClassPathsConstants.ORGANISMS_PATH + ClassPathsConstants.PREDATORS_PATH + s);
                    case "buffalo", "deer", "duck", "goat", "grub", "hog", "horse", "mouse", "rabbit", "sheep" ->
                            aClass = Class.forName(ClassPathsConstants.ORGANISMS_PATH + ClassPathsConstants.HERBIVORES_PATH + s);
                    case "grass" -> aClass = Class.forName(ClassPathsConstants.ORGANISMS_PATH + ClassPathsConstants.PLANTS_PATH + s);
                }
                if (aClass != null) {
                    organismsSamples.put(annotationProcessor.getAnimalName(aClass),
                            new Organism(annotationProcessor.getStatsLimitFromAnnotation(aClass)));
                }
            } catch (ClassNotFoundException e) {
                throw new GameException(e,"method organismsSamplesInitialization is failed");
            }
        }
        return organismsSamples;
    }

    public Map<String, HashSet<Organism>> randomOrganismCellInitialization(Map<String, Organism> organismsSamples) {
        Random random = new Random();
        Map<String, HashSet<Organism>> organismMap = new HashMap<>();
        int[] organismTypes = getOrganismTypes(organismsSamples, random);
        organismsSamples.forEach((s, organism) -> {
            boolean currentOrganismNumber = checkCurrentOrganismNumber(organism, organismTypes);
            if (currentOrganismNumber) {
                int countPerCell = random.nextInt(1, organism.getStatsLimit().maxCountPerCell());//todo
                organismMap.put(s, new HashSet<>());
                for (int i = 0; i < countPerCell; i++) {
                    organismMap.get(s).add(organism.clone());
                }

            } else {
                organismMap.put(s, new HashSet<>());
            }
        });
        return organismMap;
    }

    private int[] getOrganismTypes(Map<String, Organism> organismsSamples, Random random) {
        int[] organismTypes = new int[random.nextInt(organismsSamples.size())];
        for (int i = 0; i < organismTypes.length; i++) {
            while (true) {
                int intermediateOrganismType = random.nextInt(organismsSamples.size());
                boolean intermediateOrganismTypeFlag = false;
                for (int j = 0; j < i; j++) {
                    if (organismTypes[j] == intermediateOrganismType) {
                        intermediateOrganismTypeFlag = true;
                        break;
                    }
                }
                if (!intermediateOrganismTypeFlag) {
                    organismTypes[i] = intermediateOrganismType;
                    break;
                }
            }
        }
        return organismTypes;
    }

    private boolean checkCurrentOrganismNumber(Organism organism, int[] organismTypes) {
        boolean currentOrganismNumber = false;
        for (int organismType : organismTypes) {
            if (organism.getStatsLimit().organismNumber() == organismType) {
                currentOrganismNumber = true;
                break;
            }
        }
        return currentOrganismNumber;
    }
}

