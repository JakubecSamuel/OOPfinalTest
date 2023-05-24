package sk.stuba.fei.uim.oop.shapes;

import java.awt.*;

public class Object {

    private int x;
    private int y;
    private Color color;

    public  Object(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g, int radius, String shape){
        g.setColor(this.color);
        g.drawOval(this.x,this.y, radius, radius);
        
    }
}

