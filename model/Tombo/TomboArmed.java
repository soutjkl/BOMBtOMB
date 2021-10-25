package model.Tombo;

import model.TropelGame;

public class TomboArmed extends Tombo{
    public TomboArmed(TropelGame game, int street) {
        super(game, street);
        health = 10000;
        game.getSound().loadSound("src/poli.wav");
    }
}
