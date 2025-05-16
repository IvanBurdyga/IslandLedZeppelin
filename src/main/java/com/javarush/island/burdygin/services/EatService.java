package com.javarush.island.burdygin.services;

import com.javarush.island.burdygin.island.Island;

public class EatService extends AbstractService {

    Island island;

    public EatService(Island island) {
        super(island);
    }
}

//    @Override
//    public void run() {
//        for (Cell[] cells : island.getArea()) {
//            for (Cell cell : cells) {
//                for (Map.Entry<String, Organism> entry : cell.lifeFormsOnCell.entrySet()) {
//                    Organism value = entry.getValue();
//                    if (value instanceof Animal predator){
//                        for (Map.Entry<String, Organism> food : cell.lifeFormsOnCell.entrySet()){
//                            if (canEat(predator, food.getValue())){
//                                predator.toEat(food.getValue());
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
//    }
//
//    public boolean canEat(Organism predator, Organism food) {
//        return false;
//    }
//}
