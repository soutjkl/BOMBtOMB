package model;

import Enums.CapuchoType;
import model.Capucho.Arms.Arm;
import model.Tombo.Tombo;
import view.Collinder;
import view.ManagerFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class TropelGame extends Thread {

    private static final Random randomGenerator = new Random();
    public static final int MAP_SIZE = 500;
    private ArrayList<ArrayList<Arm>> arms;
    private ArrayList<ArrayList<Tombo>> tombo;
    public Collinder[] collinders;
    static int progress = 0;
    private boolean play;
    private Sound sound;
    private int core;
    private Timer tomboProducert,advanceTombo, time;
    private int mouseX, mouseY;
    public static CapuchoType capuType = CapuchoType.NONE;

    public TropelGame() {
        this.sound = new Sound();
        this.tombo = new ArrayList<>();
        this.arms = new ArrayList<>();
        this.collinders = new Collinder[36];
        play = true;
        start();
    }

    @Override
    public void run() {
        putSong();
        createTombo();
        addArms();
        loadTombos();
        advance();
    }

    public void putSong(){
        sound.loadSound("src/Up Night.wav");
    }

    private void createTombo(){
        for(int i = 0; i < 4; i++) {
            tombo.add(new ArrayList<>());
        }
    }

    private void addArms(){
        for(int i = 0; i < 4; i++){
            arms.add(new ArrayList<>());
        }
    }

    private void advance(){
        advanceTombo = new Timer(60, (ActionEvent e) -> {

        for(int i = 0; i < 4; i++) {
            for(Tombo t : tombo.get(i)){
                t.advance(TropelGame.this);
            }
            for (int j = 0; j < arms.get(i).size(); j++){
                Arm s = arms.get(i).get(j);
                s.advance();
            }
        }
        });
        advanceTombo.start();
    }

    private void loadTombos(){
        tomboProducert = new Timer (7000, (ActionEvent e) -> {
        Random r = new Random();
        LevelData levelData = new LevelData();
        String[] level = levelData.LEVEL[Integer.parseInt(levelData.LEVEL_ONE) - 1];
        int[][] levelValue = levelData.LEVEL_VALUE[Integer.parseInt(levelData.LEVEL_ONE)-1];
        int l = r.nextInt(4);
        int t = r.nextInt(100);
        Tombo tombo = null;
        for(int i = 0; i < levelValue.length; i++){
            if(t >= levelValue[i][0] &&  t <= levelValue[i][1]){
                tombo = Tombo.getTombo(level[i],TropelGame.this,l);
            }
        }
        this.tombo.get(l).add(tombo);
        });
        tomboProducert.start();
    }

    public static void setProgress(int num) {
        progress = progress + num;
        System.out.println(progress);
        if(progress>=150) {
            if("1".equals(LevelData.LEVEL_ONE)) {
                JOptionPane.showMessageDialog(null,"Level Completed !!!" + '\n' + "Corre a pelear que viene el SMAD");
//                ManagerFrame.mf.dispose();
                LevelData.write("2");
  //              ManagerFrame.mf = new ManagerFrame();
            }  else {
                JOptionPane.showMessageDialog(null,"Level Completed !!!" + '\n' + "More Levels will come soon !!!" + '\n' + "Resetting data");
                LevelData.write("1");
                System.exit(0);
            }
            progress = 0;
        }
    }

    public ArrayList<ArrayList<Tombo>> getTombo() {
        return tombo;
    }
    public ArrayList<ArrayList<Arm>> getArms() {
        return arms;
    }
    public int getMouseX() {
        return mouseX;
    }
    public int getMouseY() {
        return mouseY;
    }
    public Sound getSound() {
        return sound;
    }

    public Collinder[] getCollinders() {
        return collinders;
    }
}