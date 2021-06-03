package Elements;

import Graphics.Drawer;
import Graphics.Settings;

public abstract class Element extends Drawer {
    protected double V, I, R, P;
    protected Terminal tA,tB;
    public Element(Settings s) {
        super(s);
    }

}
