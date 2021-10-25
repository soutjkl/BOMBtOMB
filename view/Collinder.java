package view;

import model.Capucho.Capucho;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Collinder extends JPanel implements MouseListener {

    private Capucho capucho;
    private ActionListener listener;

    public Collinder(){
        //setBorder(new LineBorder(Color.BLACK));
        setOpaque(false);
        addMouseListener(this);
        setSize(130,150);
    }

    public Capucho getCapucho(){
        return capucho;
    }

    public void setCapucho(Capucho capucho){
        this.capucho = capucho;
    }

    public void removeCapucho(){
        capucho.stop();
        capucho = null;
    }

    public boolean isInsideCollider(int tx){
        return (tx > getLocation().x) && (tx < getLocation().x + 100);
    }

    public void setAction(ActionListener listener){
        this.listener = listener;
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
            listener.actionPerformed(new ActionEvent(this,ActionEvent.RESERVED_ID_MAX + 1,""));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
