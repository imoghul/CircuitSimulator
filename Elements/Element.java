package Elements;

import Graphics.Drawer;
import Graphics.Settings;
import java.awt.Graphics;

public abstract class Element extends Drawer {
    protected double V, I, R, P;
    protected double x1, y1, x2, y2;
    protected Terminal tA, tB;
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

    public abstract void draw(Graphics g);

}
