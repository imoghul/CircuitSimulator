package Elements;

import java.awt.Graphics;
import java.awt.Color;
import Graphics.Text;
import Graphics.Settings;

public class CurrentSource extends Element {
    private final int innerCircleR = 30;
    public CurrentSource(Settings s, double x1, double y1, double x2, double y2) {
        super(s, x1, y1, x2, y2);
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        drawLines(g, innerCircleR * 2);
        drawArrowLine(g, (int)(getMidX() - getDx(innerCircleR * 1.25)), (int)(getMidY() - getDy(innerCircleR * 1.25)), (int)(getMidX() + getDx(innerCircleR * 1.25)), (int)(getMidY() + getDy(innerCircleR * 1.25)), 15, 10);
        g.drawOval((int)(getMidX() - innerCircleR), (int)(getMidY() - innerCircleR), innerCircleR * 2, innerCircleR * 2);
    }
}
