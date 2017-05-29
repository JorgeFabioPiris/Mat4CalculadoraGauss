/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author Jorge Fabio
 */
public class Button extends JButton implements FocusListener, MouseListener {

    /**
     * Constructor de clase
     */
    public Button() {
        super();
        Button.this.setSize(new Dimension(100, 42));
        Button.this.setForeground(new Color(162, 183, 188));
        Button.this.setBorderPainted(true);
        Button.this.setContentAreaFilled(false);
        Button.this.setOpaque(true);
        Button.this.setBackground(new Color(0, 0, 0));
        Button.this.setBorder(BorderFactory.createLineBorder(new Color(162, 183, 188), 2));
        Button.this.setFocusPainted(false);
        Button.this.addFocusListener(Button.this);
        Button.this.addMouseListener(Button.this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        setBorder(BorderFactory.createLineBorder(new Color(248, 110, 1), 2));
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBorder(BorderFactory.createLineBorder(new Color(162, 183, 188), 2));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Button.this.setBackground(new Color(70, 98, 110));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Button.this.setBackground(new Color(0, 0, 0));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Button.this.setBackground(new Color(90, 130, 130));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Button.this.setBackground(new Color(0, 0, 0));
    }

}
