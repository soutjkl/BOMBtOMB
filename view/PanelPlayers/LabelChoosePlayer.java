package view.PanelPlayers;

import javax.swing.*;
import java.awt.*;

public class LabelChoosePlayer extends JLabel {

    public LabelChoosePlayer(String name, int i, int bX, int bY, int w, int h, String fontName, int size){
        setText(name);
        setBounds(bX,bY,w,h);
        setFont(new Font(fontName, Font.PLAIN,size));
        setForeground(Color.WHITE);
    }
}
