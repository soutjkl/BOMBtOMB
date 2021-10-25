package model.Capucho;

import model.Capucho.Arms.Arm;
import model.TropelGame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CapuchoLancerStick extends Capucho {
    public Timer lancingTime;

    public CapuchoLancerStick(TropelGame g, int x, int y) {
        super(g, x, y);
        lancingTime = new Timer(2170, (ActionEvent e) -> {
            if(g.getTombo().get(y).size() > 0){
                g.getArms().get(y).add(new Arm(g, getY(), 260 + getX() * 100));
                g.getSound().loadSound("src/golpe.wav");
            }
        });
        lancingTime.start();
    }

    public void stop(){
        lancingTime.stop();
    }

}
