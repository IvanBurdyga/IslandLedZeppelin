package com.javarush.island.burdygin.init;

import com.javarush.island.burdygin.config.Config;
import com.javarush.island.burdygin.island.Cell;
import com.javarush.island.burdygin.organisms.Organism;
import com.javarush.island.burdygin.organisms.animals.predators.Wolf;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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
                //area[row][col].updateNextCells(area, row, col);
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
        Set<String> animalSet = Config.getInstance().getFoodMap().keySet();
        for (String s : animalSet) {
            try {
                Class<?> aClass = Class.forName("com.javarush.island.burdygin.organisms.animals.predators." + s);

                organismsSamples.put(annotationProcessor.getAnimalName(aClass),
                        new Organism(annotationProcessor.getStatsLimitFromAnnotation(aClass)));
            } catch (ClassNotFoundException e) {
                try {
                    Class<?> aClass = Class.forName("com.javarush.island.burdygin.organisms.animals.herbivores." + s);
                    organismsSamples.put(annotationProcessor.getAnimalName(aClass),
                            new Organism(annotationProcessor.getStatsLimitFromAnnotation(aClass)));
                } catch (ClassNotFoundException ex) {
                    Class<?> aClass = null;
                    try {
                        aClass = Class.forName("com.javarush.island.burdygin.organisms.plants." + s);
                    } catch (ClassNotFoundException exc) {
                        throw new RuntimeException(exc);
                    }
                    organismsSamples.put(annotationProcessor.getAnimalName(aClass),
                            new Organism(annotationProcessor.getStatsLimitFromAnnotation(aClass)));
                    //throw new RuntimeException(ex);
                }
                //throw new RuntimeException(e);
            }


        }
        return organismsSamples;
    }

    public Map<String, ArrayList<Organism>> randomOrganismCellInitialization(Map<String, Organism> organismsSamples) {
        Random random = new Random();//todo
        Map<String, ArrayList<Organism>> organismMap = new HashMap<>();
        int countOrganismsTypes = random.nextInt(organismsSamples.size());
        for (int i = 0; i < countOrganismsTypes; i++) {
            int organismType = random.nextInt(organismsSamples.size());
            organismsSamples.forEach((s, organism) -> {
                if (organism.getStatsLimit().getAnimalNumber() == organismType) {
                    Organism newOrganism = organism.clone();
                    int flockSize = random.nextInt(organism.getStatsLimit().getMaxFlockSize());
                    newOrganism.setFlockSize(flockSize);
                    organismMap.put(s, new ArrayList<>());
                    organismMap.get(s).add(newOrganism);
                } else {
                    organismMap.put(s, new ArrayList<>());
                }
            });
        }
        return organismMap;
    }
}

