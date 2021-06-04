package Elements;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;
import java.awt.Point;

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

    final double xone=-60,yone=0,xtwo=-50,ytwo=30,xthree=-20,ythree=-30,xfour=20,yfour=30,xfive=40,yfive=-30,xsix=60,ysix=0;

    public Resistor(Settings s, double x1, double y1, double x2, double y2) {
        super(s, x1, y1, x2, y2);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        int x = (int)((this.x1+this.x2)/2.0);
        int y = (int)((this.y1+this.y2)/2.0);
        double theta = Math.atan2(getY2()-getY1(),getX2()-getX1());
        Point one = rotatePoint(xone, yone, theta);
        Point two = rotatePoint(xtwo, ytwo, theta);
        Point three = rotatePoint(xthree, ythree, theta);
        Point four = rotatePoint(xfour, yfour, theta);
        Point five = rotatePoint(xfive, yfive, theta);
        Point six = rotatePoint(xsix, ysix, theta);
        g.drawLine((int)x1,(int)y1,one.x+x,one.y+y);
        g.drawLine((int)x2,(int)y2,six.x+x,six.y+y);
        g.drawLine(one.x+x,one.y+y,two.x+x,two.y+y);
        g.drawLine(two.x+x,two.y+y,three.x+x,three.y+y);
        g.drawLine(three.x+x,three.y+y,four.x+x,four.y+y);
        g.drawLine(four.x+x,four.y+y,five.x+x,five.y+y);
        g.drawLine(five.x+x,five.y+y,six.x+x,six.y+y);
    }
    private Point rotatePoint(double x,double y,double theta){
        return new Point((int)(x*Math.cos(theta)-y*Math.sin(theta)),(int)(y*Math.cos(theta)+x*Math.sin(theta)));
    }
}

// class Point{
//     public double x, y;
//     public Point(double x, double y){
//         this.x = x;this.y= y;
//     }
// }
