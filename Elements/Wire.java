package Elements;

import java.awt.Color;
import java.awt.Graphics;

import Graphics.Settings;
public class Wire extends Element {
    public Wire(Settings s, double x1, double y1, double x2, double y2) {
        super(s, x1, y1, x2, y2);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine((int)this.x1, (int)this.y1, (int)this.x2, (int)this.y2);
    }
}
