package view.PanelCoins;

import javax.swing.*;
import java.awt.*;

public class PanelCointPlay extends JPanel  {

    public PanelCointPlay() {
        setVisible(true);
        setSize(160, 100);
        setLocation(8, 10);
        setBackground(Color.decode("#ff3744"));
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
