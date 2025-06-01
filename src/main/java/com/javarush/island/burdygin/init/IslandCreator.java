package com.javarush.island.burdygin.init;

import com.javarush.island.burdygin.exception.GameException;
import com.javarush.island.burdygin.island.Cell;
import com.javarush.island.burdygin.organisms.Organism;
import com.javarush.island.burdygin.organisms.animals.herbivores.Buffalo;
import com.javarush.island.burdygin.organisms.animals.herbivores.Deer;
import com.javarush.island.burdygin.organisms.animals.herbivores.Duck;
import com.javarush.island.burdygin.organisms.animals.herbivores.Goat;
import com.javarush.island.burdygin.organisms.animals.herbivores.Grub;
import com.javarush.island.burdygin.organisms.animals.herbivores.Hog;
import com.javarush.island.burdygin.organisms.animals.herbivores.Horse;
import com.javarush.island.burdygin.organisms.animals.herbivores.Mouse;
import com.javarush.island.burdygin.organisms.animals.herbivores.Rabbit;
import com.javarush.island.burdygin.organisms.animals.herbivores.Sheep;
import com.javarush.island.burdygin.organisms.animals.predators.Wolf;
import com.javarush.island.burdygin.organisms.animals.predators.Snake;
import com.javarush.island.burdygin.organisms.animals.predators.Fox;
import com.javarush.island.burdygin.organisms.animals.predators.Bear;
import com.javarush.island.burdygin.organisms.animals.predators.Eagle;
import com.javarush.island.burdygin.organisms.plants.Grass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class IslandCreator {

    private final AnnotationProcessor annotationProcessor;
    private final Random random;

    public IslandCreator(AnnotationProcessor annotationProcessor, Random random) {
        this.annotationProcessor = annotationProcessor;
        this.random = random;
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
                area[row][col].getNextCells(area, row, col);
            }
        }
        return area;
    }

    public Map<String, Organism> organismsSamplesInitialization() {
        Map<String, Organism> organismsSamples = new HashMap<>();
        ArrayList<Class<?>> classes = new ArrayList<>(List.of(Wolf.class, Bear.class, Eagle.class, Fox.class, Snake.class,
                Buffalo.class, Deer.class, Duck.class, Goat.class, Grub.class, Hog.class, Horse.class, Mouse.class, Rabbit.class, Sheep.class,
                Grass.class));
        for (Class<?> aClass : classes) {
            try {
                Constructor<?>[] constructors = aClass.getDeclaredConstructors();
                Organism newOrganism = (Organism) constructors[0].newInstance(annotationProcessor.getStatsLimitFromAnnotation(aClass));
                organismsSamples.put(aClass.getSimpleName(), newOrganism);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                throw new GameException("method organismsSamplesInitialization is failed");
            }
        }
        return organismsSamples;
    }

    private Map<String, HashSet<Organism>> randomOrganismCellInitialization(Map<String, Organism> organismsSamples) {
        Map<String, HashSet<Organism>> organismMap = new HashMap<>();
        int[] organismTypeNumbers = getStartOrganismTypeNumbersOnCell(organismsSamples, random);
        organismsSamples.forEach((s, organism) -> {
            organismMap.put(s, new HashSet<>());
            if (checkCurrentOrganismNumber(organism, organismTypeNumbers)) {
                int countPerCell = random.nextInt(1, organism.getStatsLimit().maxCountPerCell());
                for (int i = 0; i < countPerCell; i++) {
                    organismMap.get(s).add(organism.clone());
                }
            }
        });
        return organismMap;
    }

    private int[] getStartOrganismTypeNumbersOnCell(Map<String, Organism> organismsSamples, Random random) {
        int countOrganismTypeNumbers = random.nextInt(organismsSamples.size());
        int[] organismTypeNumbers = new int[countOrganismTypeNumbers];
        for (int i = 0; i < organismTypeNumbers.length; i++) {
            while (true) {
                int nextOrganismTypeNumber = random.nextInt(organismsSamples.size());
                boolean isAdded = false;
                for (int j = 0; j < i; j++) {
                    if (organismTypeNumbers[j] == nextOrganismTypeNumber) {
                        isAdded = true;
                        break;
                    }
                }
                if (!isAdded) {
                    organismTypeNumbers[i] = nextOrganismTypeNumber;
                    break;
                }
            }
        }
        return organismTypeNumbers;
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

