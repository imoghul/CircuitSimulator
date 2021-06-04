package Elements;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;

import Graphics.Settings;
import Graphics.Text;
import java.awt.Color;
import java.awt.image.*;

import Features.Values;
public class Resistor extends Element {
    // BufferedImage bgImage = new BufferedImage(840, 680, BufferedImage.TYPE_INT_RGB);
    // Graphics2D g2dbf = bgImage.createGraphics();
    // AffineTransform identityTrans = new AffineTransform();
    // AffineTransform af = new AffineTransform();
    public Resistor(Settings s, double x1, double y1, double x2, double y2) {
        super(s, x1, y1, x2, y2);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.drawLine((int)this.x1, (int)this.y1, (int)this.x2, (int)this.y2);
        double x = ((this.x1+this.x2)/2.0);
        double y = ((this.y1+this.y2)/2.0);
        int width = 50;
        int height = 30;
        double theta = Math.atan2(getY2()-getY1(),getX2()-getX1());

        Rectangle2D rect = new Rectangle2D.Double(-width / 2., -height / 2., width, height);
        Rectangle2D rectBack = new Rectangle2D.Double(.9*-width / 2., .9*-height / 2., .9*width, .9*height);
        
        AffineTransform transform = new AffineTransform();
        transform.translate((int)x, (int)y);
        transform.rotate(theta);

        Shape rotatedRect = transform.createTransformedShape(rect);
        Shape rotatedRectBack = transform.createTransformedShape(rectBack); 
        Graphics2D graphics= (Graphics2D) g; 
        graphics.draw(rotatedRect);
        graphics.setColor(Values.backgroundColor);
        graphics.fill(rotatedRectBack);
        graphics.setColor(Color.white);
        new Text("R",((this.x1+this.x2)/2.0),((this.y1+this.y2)/2.0),Values.timerSpeed).drawCentered(g);
    }
}
