package model.Capucho;
import model.Capucho.Arms.StonePea;
import model.TropelGame;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class CapuchoLancerStone extends Capucho {

    private Timer lancingTime;

    public CapuchoLancerStone(TropelGame g, int x, int y) {
        super(g, x, y);
        lancingTime = new Timer(2000, (ActionEvent e) -> {
            if(g.getTombo().get(y).size() > 0){
                g.getArms().get(y).add(new StonePea(g, getY(), 300 + getX() * 100));
                g.getSound().loadSound("src/golpe.wav");
            }
        });
        lancingTime.start();
    }

    @Override
    public void stop() {
        lancingTime.stop();
    }
}
