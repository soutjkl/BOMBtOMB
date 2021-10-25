package model.Capucho.Arms;

import model.Tombo.Tombo;
import model.TropelGame;

import java.awt.*;

public class Arm {

    public int x;
    public int line;
    public TropelGame g;

    public Arm(TropelGame g, int line, int start){
        this.x = start;
        this.line = line;
        this.g = g;
    }

    public void advance(){
        Rectangle r = new Rectangle(x,130+ line * 120,28,28);
        for (int i = 0; i < g.getTombo().get(line).size(); i++) {
            Tombo t = g.getTombo().get(line).get(i);
            Rectangle zRect = new Rectangle(t.getPositionX(),109 + line * 120,400,120);
            if(r.intersects(zRect)){
                t.health -= 200;
                boolean exit = false;
                if(t.health < 0){
                    System.out.println("TOMBO DIE");
                    g.getSound().loadSound("src/deadP.wav");
                    g.getTombo().get(line).remove(i);
                    g.getSound().loadSound("src/yeah.wav");

                    TropelGame.setProgress(10);
                    exit = true;
                }
                g.getArms().get(line).remove(this);
                if(exit) break;
            }
        }
        x += 15;
    }

}
