/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Jorge Fabio
 */
public class Panel extends JPanel {

    private final Dimension dimension = new Dimension(834, 740);
    private final Image image = new ImageIcon(getClass().
            getResource("/img/fondo.png")).getImage();
    private final Image logo = new ImageIcon(getClass().
            getResource("/img/facitec.png")).getImage();
    private BufferedImage bufferedImage;

    /**
     * Constructor de clase
     */
    public Panel() {
        super();
        bufferedImage = imageToBI(image);
        //tamaño del panel
        Panel.this.setSize(dimension);
        Panel.this.setPreferredSize(dimension);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //coordenadas de la figura principal
        int x1Points[] = {21, 629, 657, 737, 742, 832, 832, 814, 814, 832, 832, 121, 77, 40, 23, 23, 0, 0};
        int y1Points[] = {0, 0, 28, 28, 23, 23, 75, 91, 146, 162, 693, 693, 738, 738, 720, 68, 46, 21};
        GeneralPath polygonPrincipal = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points.length);
        polygonPrincipal.moveTo(x1Points[0], y1Points[0]);
        for (int i = 0; i < x1Points.length; i++) {
            polygonPrincipal.lineTo(x1Points[i], y1Points[i]);
        }
        polygonPrincipal.closePath();

        //transparencia del jpanel
        g2.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));

        //se cargan las texturas
        TexturePaint paint = new TexturePaint(bufferedImage,
                new Rectangle2D.Double(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight()));

        //pinta cuerpo y borde del panel
        g2.setPaint(paint);
        g2.fill(polygonPrincipal);
        g2.setColor(new Color(119, 232, 228));
        g2.setStroke(new BasicStroke(3));
        g2.draw(polygonPrincipal);

        //panel rectangular central
        Polygon panelCentral = new Polygon();
        panelCentral.addPoint(40, 40);
        panelCentral.addPoint(805, 40);
        panelCentral.addPoint(805, 680);
        panelCentral.addPoint(40, 680);
        g2.setPaint(new GradientPaint(0, 0, new Color(18, 62, 69, 240), 460, 0, new Color(0, 2, 6, 220)));
        g2.fill(panelCentral);

        //bordes panel central
        g2.setStroke(new BasicStroke(1));
        g2.setColor(new Color(221, 0, 1));
        g2.draw(panelCentral);
        //esquinas
        g2.setStroke(new BasicStroke(3));

        g2.drawLine(40, 40, 50, 40);
        g2.drawLine(40, 40, 40, 50);

        g2.drawLine(805, 40, 795, 40);
        g2.drawLine(805, 40, 805, 50);

        g2.drawLine(805, 680, 805, 670);
        g2.drawLine(805, 680, 795, 680);

        g2.drawLine(40, 680, 50, 680);
        g2.drawLine(40, 680, 40, 670);

        //logo jc mouse 🙂
        g2.drawImage(logo, 720, 595, 80, 80, null);
    }

    /**
     * dado un image retorna un BufferedImage
     *
     * @param img Image
     * @return BufferedImage
     */
    private BufferedImage imageToBI(Image img) {
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return bi;
    }

}//NetPanel
