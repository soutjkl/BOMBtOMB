package view;

import control.Presenter;
import model.TropelGame;
import view.Menu.MenuBombTomb;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

public class ManagerFrame extends JFrame {

    public static ManagerFrame mf;
    public static final String TITTLE = "BombsTombs";
    public PanelGame panelGame;

    public ManagerFrame(boolean b, TropelGame game) {
        MenuBombTomb menu = new MenuBombTomb(game);
        setSize(610,630);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/menu.jpg"))).getImage());
        getLayeredPane().add(menu);
        menu.repaint();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public ManagerFrame(TropelGame game){
        setSize(1370, 700);
        setTitle(TITTLE);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/menu.jpg"))).getImage());
        panelGame = new PanelGame();
        add(panelGame, BorderLayout.CENTER);

        setVisible(true);
    }


    public void refreshGame( ){
        //add(panelGame, BorderLayout.CENTER);
    }

    public static void begin(TropelGame game) {
        mf.dispose();
        mf = new ManagerFrame(game);
    }

}
