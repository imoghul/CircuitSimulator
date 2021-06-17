package Elements;

import Graphics.Drawer;
import Graphics.Settings;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Element extends Drawer {
    protected double V, I, R, P;
    protected double x1, y1, x2, y2;
    public Terminal tA, tB;
    public Element(Settings s, double x1, double y1, double x2, double y2) {
        super(s);
        tA = new Terminal(x1, y1);
        tB = new Terminal(x2, y2);
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
        tA.x = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
        tA.y = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
        tB.x = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
        tB.y = y2;
    }

    public double getMidX() {
        return ((this.x1 + this.x2) / 2.0);
    }

    public double getMidY() {
        return ((this.y1 + this.y2) / 2.0);
    }

    public double getTheta() {
        return Math.atan2(getY2() - getY1(), getX2() - getX1());
    }

    public abstract void draw(Graphics g);

    public void drawLines(Graphics g, double gap) {
        double dx = getDx(gap);//(gap / 2) * Math.cos(getTheta());
        double dy = getDy(gap);//(gap / 2) * Math.sin(getTheta());
        g.drawLine((int)x1, (int)y1, (int)(getMidX() - dx), (int)(getMidY() - dy));
        g.drawLine((int)x2, (int)y2, (int)(getMidX() + dx), (int)(getMidY() + dy));
    }

    protected void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx * dx + dy * dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy / D, cos = dx / D;

        x = xm * cos - ym * sin + x1;
        ym = xm * sin + ym * cos + y1;
        xm = x;

        x = xn * cos - yn * sin + x1;
        yn = xn * sin + yn * cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g.drawLine(x1, y1, x2, y2);
        g.fillPolygon(xpoints, ypoints, 3);
    }

    protected Point rotatePoint(double x, double y, double theta) {
        return new Point((int)(x * Math.cos(theta) - y * Math.sin(theta)), (int)(y * Math.cos(theta) + x * Math.sin(theta)));
    }

    protected double getDx(double gap) {
        return (gap / 2) * Math.cos(getTheta());
    }

    protected double getDy(double gap) {
        return (gap / 2) * Math.sin(getTheta());
    }
}
