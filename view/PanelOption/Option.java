package view.PanelOption;

import javax.swing.*;
import java.awt.*;

public class Option extends JPanel {

    public Option(){
        setVisible(true);
        setBackground(Color.GRAY);
        setSize(600, 40);
        setLocation(380,630);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(20, 20);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

    }
}
