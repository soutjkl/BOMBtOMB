package view.PanelOption;

import Enums.CapuchoType;
import control.Presenter;
import model.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonOption extends JButton {



    public ButtonOption(String name, int bX, int bY, int w, int h, String fontName, int size) {
        setText(name);
        setLocation(bX, bY);
        setSize(w, h);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFont(new Font(fontName, Font.PLAIN, size));
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }



}
