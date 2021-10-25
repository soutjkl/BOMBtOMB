package model.Tombo;

import model.Sound;
import model.TropelGame;
import view.Collinder;
import view.ManagerFrame;

import javax.swing.*;

public class Tombo {

    public int health = 2000;
    private int positionX = 1370;
    private int myStreet;
    private boolean isMoving = true;
    private int slow = 0;
    private TropelGame game;

    public Tombo(TropelGame game, int street) {
        this.myStreet = street;
        this.game = game;
    }

    public void advance(TropelGame game) throws  NullPointerException{
        if (isMoving) {
            boolean isCollides = false;
            Collinder collided = null;

            for(int i = myStreet * 9; i < (myStreet + 1) * 9; i++){
                if (game.getCollinders()[i].getCapucho() != null && game.getCollinders()[i].isInsideCollider(positionX)) {
                    isCollides = true;
                    collided = game.getCollinders()[i];
                }
            }

            if (!isCollides) {
                if (slow > 0) {
                    if (slow % 2 == 0) {
                        positionX--;
                    }
                    slow--;
                } else {
                    positionX -= 1;
                }
            }
            else {
                collided.getCapucho().health -= 10;
                if(collided.getCapucho().health < 0){
                    game.getSound().loadSound("src/dead.wav");
                    collided.removeCapucho();
                }
            }
            if (positionX < 100) {
                System.out.println(positionX);
                isMoving = false;
                Sound.clip.stop();
                game.getSound().loadSound("src/end.wav");
                JOptionPane.showMessageDialog(null, "LOS TOMBOS NOS HAN INVADIDO!" + '\n' + "Starting the level again");
            }
        }
    }

    public void slow() {
        slow = 1000;
    }

    public static Tombo getTombo(String type, TropelGame game, int street) {
        Tombo t = new Tombo(game,street);
        switch (type) {
            case "Bachelor": t = new TomboBachelor(game, street);
                break;
            case "TomboArmed": t = new TomboArmed(game, street);
                break;
        }
        return t;
    }

    public int getPositionX() {
        return positionX;
    }

}
