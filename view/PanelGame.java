package view;

import Burn.Burn;
import Enums.CapuchoType;
import control.Presenter;
import model.Capucho.Arms.StonePea;
import model.Capucho.Capucho;
import model.Capucho.CapuchoLancerStick;
import model.Capucho.CapuchoLancerStone;
import model.Capucho.CapuchoShield;
import model.Capucho.Arms.Arm;
import model.Tombo.Tombo;
import model.Tombo.TomboArmed;
import model.Tombo.TomboBachelor;
import model.TropelGame;
import view.PanelOption.ButtonOption;
import view.PanelOption.Option;
import view.PanelPlayers.ButtonChoose;
import view.PanelPlayers.LabelChoosePlayer;
import view.PanelPlayers.PanelChoosePlayer;
import view.PanelCoins.PanelCointPlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

public class PanelGame extends JLayeredPane {


    private final Image imgBack, imgCoins, imgStone,imgTombNormal,imgTombArm,imgCapuchoNormal,imgStick,imgCapuchoStick,imgCapuchoStone,imgCapuchoEscudo;
    private PanelCointPlay cointPlay;
    private Option option;
    private ButtonChoose choose;
    private ButtonOption buttonOption;
    private LabelChoosePlayer label;
    private TropelGame game;
    private Timer redrawTimer;
    private PanelChoosePlayer panelChoose;

    public PanelGame() {
        imgBack = new ImageIcon(Objects.requireNonNull(getClass().getResource(Burn.BACKGROUND))).getImage();
        imgCoins = new ImageIcon(Objects.requireNonNull(getClass().getResource(Burn.IMG_COIN))).getImage();
        imgStone = new ImageIcon(Objects.requireNonNull(getClass().getResource(Burn.IMG_STONE))).getImage();
        imgStick = new ImageIcon(Objects.requireNonNull(getClass().getResource(Burn.IMG_STICK))).getImage();
        imgTombNormal = new ImageIcon(Objects.requireNonNull(getClass().getResource(Burn.IMG_TOMB_NORMAL))).getImage();
        imgTombArm = new ImageIcon(Objects.requireNonNull(getClass().getResource(Burn.IMG_TOMB_ARM))).getImage();
        imgCapuchoNormal = new ImageIcon(Objects.requireNonNull(getClass().getResource(Burn.CAP_BLACK))).getImage();
        imgCapuchoStick = new ImageIcon(Objects.requireNonNull(getClass().getResource(Burn.CAP_STICK))).getImage();
        imgCapuchoStone = new ImageIcon(Objects.requireNonNull(getClass().getResource(Burn.CAP_STONE))).getImage();
        imgCapuchoEscudo = new ImageIcon(Objects.requireNonNull(getClass().getResource(Burn.CAP_ESCUDO))).getImage();
        panelChoose = new PanelChoosePlayer();
        option = new Option();
        game = new TropelGame();

        putCollider(game);
        putPanelCoint();
        putPanelOption();
        putPanelChooseCapuchos();
        updateActually();
        //game.getCollinders()[9].setCapucho(new CapuchoLancerStone(game, 0, 1));
        //game.getTombo().get(1).add(new Tombo(1));
    }



    public void updateActually(){
        redrawTimer = new Timer(25, (ActionEvent e)-> repaint());
        redrawTimer.start();
    }

    private void putCollider(TropelGame game) {
        for (int i = 0; i < 36; i++) {
            Collinder c = new Collinder();
            c.setLocation(160 + (i % 9) * 130, 35 + (i / 9) * 150);
            c.setAction(new Presenter(game, (i % 9),(i / 9)));
            game.getCollinders()[i] = c;
            add(c);
        }
    }
    private void putPanelCoint() {
        cointPlay = new PanelCointPlay();
        label = new LabelChoosePlayer("BONUS", 100, 58, 2, 220, 40, Burn.FONT_IMPACT, 20);
        add(label);
        choose = new ButtonChoose(Burn.IMG_COIN, 100, 100, 40, 32, 50, 50);
        add(choose);
        label = new LabelChoosePlayer("COINS", 100, 56, 75, 220, 40, Burn.FONT_IMPACT, 15);
        add(label);
        add(cointPlay);
    }

    private void putPanelChooseCapuchos() {
        panelChoose = new PanelChoosePlayer();
        capuchoRed();
        capuchoYellow();
        capuchoNormal();
        add(panelChoose);
    }

    private void putPanelOption(){
        option = new Option();
        screemshot();
        moodPause();
        moodReanude();
        menu();
        add(option);
    }

    private void screemshot() {
        buttonOption = new ButtonOption("CAPTURAR", 410, 625, 120, 40, Burn.FONT_IMPACT, 20);

        add(buttonOption);
    }

    private void moodPause() {
        buttonOption = new ButtonOption("PAUSAR", 550, 625, 120, 40, Burn.FONT_IMPACT, 20);
        add(buttonOption);
    }

    private void moodReanude() {
        buttonOption = new ButtonOption("REANUDAR", 690, 625, 120, 40, Burn.FONT_IMPACT, 20);
        add(buttonOption);
    }

    private void menu() {
        buttonOption = new ButtonOption("MENU", 830, 625, 120, 40, Burn.FONT_IMPACT, 20);
        add(buttonOption);
    }

    private void capuchoRed( ) {
        choose = new ButtonChoose(Burn.NAME_SQUIRE, Burn.CAP_RED, 130, 85, 15, 150, 160, 240);
        label = new LabelChoosePlayer(Burn.NAME_SQUIRE, 100, 50, 230, 220, 40, Burn.FONT_IMPACT, 20);
        choose.setAction((ActionEvent e) -> {
            TropelGame.capuType = CapuchoType.ESCUDO;
        });
        add(label);
        add(choose);
    }
    private void capuchoYellow( ) {
        choose = new ButtonChoose(Burn.LANCER, Burn.CAP_YELLOW, 130, 85, 15, 280, 160, 240);
        label = new LabelChoosePlayer(Burn.LANCER,100, 45, 360, 220, 40, Burn.FONT_IMPACT, 20);
        choose.setAction((ActionEvent e) -> {
            TropelGame.capuType = CapuchoType.CAP_STONE;
        });
        add(label);
        add(choose);
    }
    private void capuchoNormal( ) {
        choose = new ButtonChoose(Burn.LANCER, Burn.CAP_BLACK, 130, 85, 15, 410, 160, 240);
        label = new LabelChoosePlayer(Burn.LANCER, 100, 45, 490, 220, 40, Burn.FONT_IMPACT, 20);
        choose.setAction((ActionEvent e) -> {
            TropelGame.capuType = CapuchoType.STICK;
        });
        add(label);
        add(choose);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgBack, 0, 0, null);
        paintCapuchos(g);
        paintTombs(g);
    }

    private void paintTombs(Graphics g) {
        for (int i = 0; i < 4; i++) {
            for (Tombo z : game.getTombo().get(i)) {
                if (z instanceof TomboBachelor) {

                    g.drawImage(imgTombNormal, z.getPositionX(), 35 + (i * 150), null);
                } else if (z instanceof TomboArmed){

                    g.drawImage(imgTombArm, z.getPositionX(), 35 + (i * 150), null);
                }
            }
            for(int j = 0; j < game.getArms().get(i).size(); j++) {
                Arm s = game.getArms().get(i).get(j);
                if (s instanceof StonePea) {
                    g.drawImage(imgStone, s.x, 100 + (i * 150), null);
                } else {
                    g.drawImage(imgStick, s.x, 100 + (i * 150), null);
                }
            }
        }
    }

    private void paintCapuchos(Graphics g) {
        for (int i = 0; i < 36; i++){
            Collinder c = game.getCollinders()[i];
            if(c.getCapucho() != null) {
                Capucho p = c.getCapucho();
                if (p instanceof CapuchoLancerStone) {
                    g.drawImage(imgCapuchoStone, 170 + (i % 9) * 130, 35 + (i / 9) * 150, null);
                }
                if (p instanceof CapuchoLancerStick) {
                    g.drawImage(imgCapuchoStick, 170 + (i % 9) * 130, 35 + (i / 9) * 150, null);
                }
                if(p instanceof CapuchoShield){
                    g.drawImage(imgCapuchoEscudo, 170 + (i % 9) * 130, 35 + (i / 9) * 150, null);
                }
            }
        }
    }

}