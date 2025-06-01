package com.javarush.island.burdygin.view;

import com.javarush.island.burdygin.api.view.View;
import com.javarush.island.burdygin.config.Config;
import com.javarush.island.burdygin.island.Cell;
import com.javarush.island.burdygin.island.Island;

public class ConsoleView implements View {

    private final Island island;

    public ConsoleView(Island island) {
        this.island = island;
    }

    @Override
    public void show() {
        printStats();
        printMap();
    }

    private void printStats() {
        System.out.println();
        island.safeUpdateStatistic().forEach((s, value) -> System.out.printf("%s = %d ", s, value));
    }

    private void printMap() {
        printHorizontalLine();
        island.getRowStream().forEach(this::printRow);
    }

    private void printRow(Cell[] cells) {
        for (int i = 0; i < cells.length; i++) {
            safePrintOneCell(cells[i]);
            if (i == cells.length - 1) {
                System.out.print("┃");
                printHorizontalLine();
            }
        }
    }

    private void printHorizontalLine() {
        System.out.print("\n" + ViewSymbols.HORIZONTAL_LINE.repeat(Config.getInstance().getCols()) + "\n");
    }

    private void safePrintOneCell(Cell cell) {
        cell.getLock().lock();
        try {
            System.out.printf("%s", ViewSymbols.VERTICAL_LINE);
            cell.getOrganismMap().forEach((s, organisms) -> {
                if (!organisms.isEmpty()) {
                    System.out.printf("%s", organisms.stream().findAny().get().getStatsLimit().icon());
                } else {
                    System.out.printf("%s", ViewSymbols.EMPTY_LINE);
                }
            });
            System.out.print("\t");
        } finally {
            cell.getLock().unlock();
        }
    }
}