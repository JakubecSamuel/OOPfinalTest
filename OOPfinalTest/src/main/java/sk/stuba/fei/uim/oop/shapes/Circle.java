package sk.stuba.fei.uim.oop.shapes;

import java.awt.*;

public class Circle {

    private int x;
    private int y;
    private Color color;

    public  Circle(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g, int radius){
        g.setColor(this.color);
        g.drawOval(this.x,this.y, radius, radius);
    }
}

