package sk.stuba.fei.uim.oop.shapes;

import java.awt.*;

public class Path {

    private int x;
    private int y;
    private Color color;



    public  Path(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillOval(this.x,this.y, 2, 2);
    }
}

