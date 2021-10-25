package model.Capucho;

import model.TropelGame;

public class CapuchoShield extends Capucho {

    public CapuchoShield(TropelGame g, int x, int y) {
        super(g, x, y);
        health = 5000;
    }

    @Override
    public void stop() {
    }
}
