package view.Menu;

import javax.swing.*;
import java.awt.*;

public class ButtonTop extends JButton {

    public ButtonTop(String name, int x, int y, int w, int h){
        setText(name);
        setSize(w,h);
        setLocation(x,y);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
