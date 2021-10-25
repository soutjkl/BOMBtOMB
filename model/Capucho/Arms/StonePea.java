package model.Capucho.Arms;

import model.Tombo.Tombo;
import model.TropelGame;

import java.awt.*;

public class StonePea extends Arm{

    public StonePea(TropelGame g, int line, int start) {
        super(g, line, start);
    }

    @Override
    public void advance() {
        Rectangle pRect = new Rectangle(x,130+ line *120,28,28);
        for (int i = 0; i < g.getTombo().get(line).size(); i++) {
            Tombo t = g.getTombo().get(line).get(i);
            Rectangle zRect = new Rectangle(t.getPositionX(),109 + line *120,400,120);
            if(pRect.intersects(zRect)){
                t.health -= 300;
                t.slow();
                boolean exit = false;
                if(t.health < 0){
                    g.getSound().loadSound("src/deadP.wav");
                    System.out.println("Tombo DIE");
                    TropelGame.setProgress(10);
                    g.getTombo().get(line).remove(i);
                    g.getSound().loadSound("src/yeah.wav");
                    exit = true;
                }
                g.getArms().get(line).remove(this);
                if(exit) break;
            }
        }
        x += 20;
    }
}
