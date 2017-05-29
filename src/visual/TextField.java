/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jorge Fabio
 */
public class TextField extends JTextField implements FocusListener {

    private Color borderColor = new Color(162, 183, 188);

    /**
     * Constructor de clase
     */
    public TextField() {
        super();
        TextField.this.setText("");
        TextField.this.setForeground(new Color(162, 183, 188));
        TextField.this.setPreferredSize(new Dimension(200, 36));
        TextField.this.setVisible(true);
        TextField.this.setFont(new Font("Agency FB", Font.PLAIN, 18));
        TextField.this.setBorder(new EmptyBorder(0, 12, 0, 12));
        TextField.this.setCaretColor(new Color(248, 110, 1));
        TextField.this.setSelectionColor(new Color(248, 110, 1));
        TextField.this.setSelectedTextColor(new Color(162, 183, 188));
        TextField.this.putClientProperty("caretWidth", 4);
        TextField.this.setOpaque(false);
        TextField.this.addFocusListener(TextField.this);
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Polygon fig = new Polygon();
        fig.addPoint(0, 0);
        fig.addPoint(getWidth() - 3, 0);
        fig.addPoint(getWidth() - 3, getHeight() - 18);
        fig.addPoint(getWidth() - 18, getHeight() - 3);
        fig.addPoint(0, getHeight() - 3);

        g2.setColor(new Color(8, 43, 49, 200));
        g2.fill(fig);

        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(3));
        g2.draw(fig);

        super.paintComponent(g);
    }

    @Override
    public void focusGained(FocusEvent e) {
        borderColor = new Color(248, 110, 1);
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        borderColor = new Color(162, 183, 188);
        repaint();
    }

}
