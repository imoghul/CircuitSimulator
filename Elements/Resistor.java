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
    final double xone = -30, yone = 0, xtwo = -24, ytwo = 15, xthree = -12, ythree = -15, xfour = 0, yfour = 15, xfive = 12, yfive = -15, xsix = 24, ysix = 15, xseven = 30, yseven = 0;
    public Resistor(Settings s, double x1, double y1, double x2, double y2) {
        super(s, x1, y1, x2, y2);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        int x = (int)this.getMidX();
        int y = (int)this.getMidY();
        double theta = this.getTheta();

        Point one = rotatePoint(xone, yone, theta);
        Point two = rotatePoint(xtwo, ytwo, theta);
        Point three = rotatePoint(xthree, ythree, theta);
        Point four = rotatePoint(xfour, yfour, theta);
        Point five = rotatePoint(xfive, yfive, theta);
        Point six = rotatePoint(xsix, ysix, theta);
        Point seven = rotatePoint(xseven, yseven, theta);

        g.drawLine((int)x1, (int)y1, one.x + x, one.y + y);
        g.drawLine((int)x2, (int)y2, seven.x + x, seven.y + y);

        g.drawLine(one.x + x, one.y + y, two.x + x, two.y + y);
        g.drawLine(two.x + x, two.y + y, three.x + x, three.y + y);
        g.drawLine(three.x + x, three.y + y, four.x + x, four.y + y);
        g.drawLine(four.x + x, four.y + y, five.x + x, five.y + y);
        g.drawLine(five.x + x, five.y + y, six.x + x, six.y + y);
        g.drawLine(six.x + x, six.y + y, seven.x + x, seven.y + y);
    }
}