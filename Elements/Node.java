package Elements;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
public class Node {
    private ArrayList<Terminal> points = new ArrayList<>();
    private double x,y;
    public Node(){

    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void draw(Graphics g){
        Color original = g.getColor();
        g.setColor(Color.darkGray);
        g.fillOval((int)(getX()-2.5),(int)(getY()-2.5),5,5);
        g.setColor(original);
    }
    public void emphasize(Graphics g){
        Color original = g.getColor();
        g.setColor(Color.darkGray);
        g.fillOval((int)(getX()-5),(int)(getY()-5),10,10);
        g.setColor(original);
    }
}
