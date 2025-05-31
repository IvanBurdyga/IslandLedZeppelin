package com.javarush.island.burdygin.exception;

public class GameException extends RuntimeException {

    public GameException(Exception e, String message){
        super(message);
    }

}
