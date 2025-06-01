package com.javarush.island.burdygin;

import com.javarush.island.burdygin.api.view.View;
import com.javarush.island.burdygin.init.AnnotationProcessor;
import com.javarush.island.burdygin.init.IslandCreator;
import com.javarush.island.burdygin.island.Island;
import com.javarush.island.burdygin.services.*;
import com.javarush.island.burdygin.services.core.GameCore;
import com.javarush.island.burdygin.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleRunner {
    public static void main(String[] args) {
        Island island = new Island(new IslandCreator(new AnnotationProcessor(), new Random()));
        View view = new ConsoleView(island);
        List<AbstractService> services = new ArrayList<>(List.of(
                new ViewService(view),
                new EatService(island),
                new SpawnService(island),
                new MoveService(island)));
        GameCore gameCore = new GameCore(services);
        gameCore.gameRun();
    }
}