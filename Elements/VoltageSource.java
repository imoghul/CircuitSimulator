package Elements;

import Graphics.Settings;
import Graphics.Text;

import java.awt.Color;
import java.awt.Graphics;

import Features.Values;

public class VoltageSource extends Element {
    private final int innerCircleR = 30;
    public VoltageSource(Settings s, double x1, double y1, double x2, double y2) {
        super(s, x1, y1, x2, y2);
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        drawLines(g, innerCircleR * 2);
        new Text("+", (int)(getMidX() + getDx(innerCircleR * 1.25)), (int)(getMidY() + getDy(innerCircleR * 1.25)), Values.timerSpeed).drawCentered(g);
        new Text("-", (int)(getMidX() - getDx(innerCircleR * 1.25)), (int)(getMidY() - getDy(innerCircleR * 1.25)), Values.timerSpeed).drawCentered(g);
        g.drawOval((int)(getMidX() - innerCircleR), (int)(getMidY() - innerCircleR), innerCircleR * 2, innerCircleR * 2);
    }
}
