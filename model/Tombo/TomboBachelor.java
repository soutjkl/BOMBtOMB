package model.Tombo;

import model.TropelGame;

public class TomboBachelor extends Tombo{

    public TomboBachelor(TropelGame game, int street) {
        super(game, street);
        game.getSound().loadSound("src/o.wav");

    }
}
