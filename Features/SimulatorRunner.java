package Features;
import java.awt.Color;
import Elements.*;
import Features.Values.CircuitElements;
import Graphics.*;

import java.awt.Graphics;
import java.awt.Point;
public class SimulatorRunner {
    private static double beginX = -1, beginY = -1, endX = -1, endY = -1;
    private static boolean isActive = false;
    private static Element current;
    public static void run(Graphics g) {

        if(Values.mouse.getIsClicked()) {
            isActive = true;
            SimulatorRunner.beginX = Values.mouse.getX();
            SimulatorRunner.beginY = Values.mouse.getY();
            SimulatorRunner.endX = Values.mouse.getX();
            SimulatorRunner.endY = Values.mouse.getY();

            if(Values.currentItem == CircuitElements.WIRE) {
                Values.elements.add(new Wire(new Settings(Values.mouse.getX(), Values.mouse.getY(), 1, 0, 0, "wire", Values.timerSpeed), SimulatorRunner.beginX, SimulatorRunner.beginY, SimulatorRunner.endX, SimulatorRunner.endY));
            } else if(Values.currentItem == CircuitElements.RESISTOR) {
                Values.elements.add(new Resistor(new Settings(Values.mouse.getX(), Values.mouse.getY(), 1, 0, 0, "wire", Values.timerSpeed), SimulatorRunner.beginX, SimulatorRunner.beginY, SimulatorRunner.endX, SimulatorRunner.endY));
            }
        } else if(Values.mouse.getIsPressed()) {
            SimulatorRunner.endX = Values.mouse.getX();
            SimulatorRunner.endY = Values.mouse.getY();
        } else {
            isActive = false;
        }

        // boolean isActive = !(beginX==-1 && beginY==-1 && endX==-1 && endY==-1);
        if(isActive) {
            Element temp = Values.elements.get(Values.elements.size() - 1);
            temp.setX1(SimulatorRunner.beginX);
            temp.setY1(SimulatorRunner.beginY);
            temp.setX2(SimulatorRunner.endX);
            temp.setY2(SimulatorRunner.endY);
            temp.draw(g);
        }

        for(int i = 0 ; i < Values.elements.size(); ++i) {
            Values.elements.get(i).draw(g);
        }

        System.out.println(Values.elements.size());
        // System.out.println(SimulatorRunner.beginX+", "+SimulatorRunner.beginY+"\t"+SimulatorRunner.endX+", "+SimulatorRunner.endY);
    }
}
