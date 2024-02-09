package org.example4.playo;

public abstract class Game {

    public void process() {
        start();
        play();
        end();
    }

    public void start() {
        System.out.println(this.getClass() + ":_START");
    }

    public void end() {
        System.out.println(this.getClass() + ":_END");
    }

    public abstract void play();
}
