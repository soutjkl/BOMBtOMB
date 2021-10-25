package view.Menu;

import Burn.Burn;
import model.TropelGame;
import view.ManagerFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import javax.swing.*;


public class MenuBombTomb extends JLabel {

    private ButtonTop button;
    private final Image imgBack;

    public MenuBombTomb(TropelGame game ) {
        setSize(700, 700);
        imgBack = new ImageIcon(Objects.requireNonNull(getClass().getResource(Burn.MENU))).getImage();
        panel(game);
    }


    private void panel(TropelGame game) {
        button = new ButtonTop("", 240,7,170,40);
        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                putClick(evt, game);
            }
        });
        add(button);
    }

    private void putClick(MouseEvent evt, TropelGame game) {
        ManagerFrame.begin(game);
        game.getSound().stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgBack, 0, 0,600,600, null);
    }


}