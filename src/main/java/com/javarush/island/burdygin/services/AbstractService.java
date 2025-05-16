package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.island.Cell;
import com.javarush.island.burdygin.island.Island;

public class AbstractService implements Runnable {

    private final Island island;

    public AbstractService(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        for (Cell[] cells : island.getArea()) {
            for (Cell cell : cells) {
//                cell.lifeFormsOnCell.forEach();
            }
        }
    }
}
