package model.Capucho;

import model.TropelGame;

public abstract class Capucho {

    public int health;
    private int x;
    private int y;

    public Capucho(TropelGame g, int x, int y) {
        this.x = x;
        this.y = y;
        this.health = 250;
    }

    public void stop(){}


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
