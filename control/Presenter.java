package control;

import Enums.CapuchoType;
import model.Capucho.CapuchoLancerStick;
import model.Capucho.CapuchoLancerStone;
import model.Capucho.CapuchoShield;
import model.TropelGame;
import view.ManagerFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Presenter implements ActionListener, MouseMotionListener {

    private  TropelGame game;
    int x, y;
    private boolean b;

    public Presenter() {
        this.game = new TropelGame();
        ManagerFrame.mf = new ManagerFrame(b,game);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = game.getMouseX();
        int y = game.getMouseY();
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public Presenter(TropelGame game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (game.capuType == CapuchoType.ESCUDO) {
            game.getSound().loadSound("src/escudo.wav");
            game.getCollinders()[x + y * 9].setCapucho(new CapuchoShield(game, x, y));
        }
        if (game.capuType == CapuchoType.CAP_STONE) {
            game.getSound().loadSound("src/escudo.wav");
            game.getCollinders()[x + y * 9].setCapucho(new CapuchoLancerStone(game, x, y));
        }
        if (game.capuType == CapuchoType.STICK) {
            game.getSound().loadSound("src/escudo.wav");
            game.getCollinders()[x + y * 9].setCapucho(new CapuchoLancerStick(game, x, y));
        }

        game.capuType = CapuchoType.NONE;

    }
}
