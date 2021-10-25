package view.PanelPlayers;

import Enums.CapuchoType;
import control.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class ButtonChoose extends JButton implements MouseListener {
    private int hm;
    private int wm;
    private int lX;
    private int lY;
    private ActionListener listener;

    private Image img;

    public ButtonChoose(String name, String img, int sizeX, int sizeY, int lX, int lY, int wm, int hm) {
        this.hm = hm;
        this.wm = wm;
        addMouseListener(this);
        setLocation(lX, lY);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setSize(sizeX, sizeY);
        this.img = new ImageIcon(Objects.requireNonNull(getClass().getResource(img))).getImage();
        setVisible(true);
    }

    public ButtonChoose(String img, int sizeX, int sizeY, int lX, int lY, int wm, int hm) {
        this.hm = hm;
        this.wm = wm;
        this.lX = lX;
        this.lY = lY;
        setLocation(lX, lY);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        this.setSize(sizeX, sizeY);
        this.img = new ImageIcon(Objects.requireNonNull(getClass().getResource(img))).getImage();
        setVisible(true);
    }

    public void setAction(ActionListener listener){
        this.listener = listener;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, lX-20, lY-30, wm, hm, null);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(listener != null){
            listener.actionPerformed(new ActionEvent(this,ActionEvent.RESERVED_ID_MAX+1,""));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
