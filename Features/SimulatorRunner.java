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

        // update nodes positions
        for(int i = 0 ;i<Values.nodesH*Values.nodesW;++i){
            Values.nodes.get(i).setX((i%Values.nodesW)*(Values.displayW/Values.nodesW)+.5*(Values.displayW/Values.nodesW));
            Values.nodes.get(i).setY((i/Values.nodesW)*(Values.displayH/Values.nodesH)+.5*(Values.displayH/Values.nodesH));
            Values.nodes.get(i).draw(g);
        }


        // get dragged x and y values
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

        // snap x andd y values to a node
        Node begin = SimulatorRunner.snapToNode(beginX, beginY);
        Node end = SimulatorRunner.snapToNode(endX, endY);
        beginX=begin.getX();
        beginY=begin.getY();
        endX = end.getX();
        endY = end.getY();
        SimulatorRunner.snapToNode(Values.mouse.getX(), Values.mouse.getY()).emphasize(g);

        // draw the element
        if(isActive && !(beginX==endX && beginY==endY)) {
            Element temp = Values.elements.get(Values.elements.size() - 1);
            temp.setX1(SimulatorRunner.beginX);
            temp.setY1(SimulatorRunner.beginY);
            temp.tA.n = begin;
            temp.setX2(SimulatorRunner.endX);
            temp.setY2(SimulatorRunner.endY);
            temp.tB.n = end;
            temp.draw(g);
        }

        for(int i = 0 ; i < Values.elements.size(); ++i) {
            Values.elements.get(i).draw(g);
        }
    }

    private static Node snapToNode(double x, double y){
        double distances[] = new double[Values.nodes.size()];
        for(int i = 0;i<distances.length;++i){
            distances[i] = Math.sqrt(Math.pow(x-Values.nodes.get(i).getX(),2)+Math.pow(y-Values.nodes.get(i).getY(),2));
        }
        double min=distances[0];
        int indexMin=0;
        for(int i = 1;i<distances.length;++i){
            if(distances[i]<min){
                min = distances[i];
                indexMin=i;
            }
        }
        return Values.nodes.get(indexMin);
    }

    
}
