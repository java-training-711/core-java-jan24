package org.example4.playo;

public class GameManager {
    public static void main(String[] args) {
        Game carGame = new CarGame();
        carGame.process();
        System.out.println("-------------------");
        Game ludoGame = new LudoGame();
        ludoGame.process();
    }
}
