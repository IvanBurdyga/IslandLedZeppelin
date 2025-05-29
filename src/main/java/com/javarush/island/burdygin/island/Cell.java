package com.javarush.island.burdygin.island;

import com.javarush.island.burdygin.organisms.Organism;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {

    @Getter
    private final Lock lock = new ReentrantLock(true);
    @Getter
    @Setter
    private Map<String, HashSet<Organism>> organismMap;
    private final List<Cell> nextCells = new ArrayList<>();

    public Cell(Map<String, HashSet<Organism>> organismMap) {
        this.organismMap = organismMap;
    }

    public void updateNextCells(Cell[][] cells, int row, int col) {
        if (row > 0) {
            nextCells.add(cells[row - 1][col]);
        }
        if (col > 0) {
            nextCells.add(cells[row][col - 1]);
        }
        if (row < cells.length - 1) {
            nextCells.add(cells[row + 1][col]);
        }
        if (col < cells[row].length - 1) {
            nextCells.add(cells[row][col + 1]);
        }
    }

    public Cell getNextCell(Random random) {
        int nextCellNumber = random.nextInt(nextCells.size());
        return nextCells.get(nextCellNumber);
    }

}
