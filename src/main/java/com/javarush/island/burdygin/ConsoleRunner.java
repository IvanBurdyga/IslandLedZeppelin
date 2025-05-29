package com.javarush.island.burdygin;

import com.javarush.island.burdygin.api.service.Service;
import com.javarush.island.burdygin.api.view.View;
import com.javarush.island.burdygin.init.AnnotationProcessor;
import com.javarush.island.burdygin.init.IslandCreator;
import com.javarush.island.burdygin.island.Island;
import com.javarush.island.burdygin.services.EatService;
import com.javarush.island.burdygin.services.ViewService;
import com.javarush.island.burdygin.services.core.GameCore;
import com.javarush.island.burdygin.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleRunner {
    public static void main(String[] args) {
        Island island = new Island(new IslandCreator(new AnnotationProcessor()));
        View view = new ConsoleView(island);
        Service viewService = new ViewService(view);
        Service eatService = new EatService(island);
        List<Service> services = new ArrayList<>(List.of(viewService, eatService));
        GameCore gameCore = new GameCore(island,services);
        gameCore.gameRun();
    }
}
