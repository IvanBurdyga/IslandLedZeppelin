package com.javarush.island.burdygin.exception;

public class GameException extends RuntimeException {
    public GameException(String message) {
        super(message);
    }

    public GameException() {
    }

    public GameException(Exception e) {
    }

    public GameException(Exception e, String message){
        super(message);
    }

}
