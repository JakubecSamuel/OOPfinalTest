package sk.stuba.fei.uim.oop.shapes;

import java.awt.*;

public class Hourglass {

    private int x;
    private int y;
    private Color color;

    public  Hourglass(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g, int radius){
        g.setColor(this.color);
        int[] xPoints = {this.x, this.x + radius, this.x + radius/2};
        int[] yPoints = {this.y, this.y, this.y + radius/2};
        g.fillPolygon(xPoints, yPoints, 3);
        int[] xPoints1 = {this.x, this.x + radius, this.x + radius/2};
        int[] yPoints1 = {this.y + radius, this.y + radius, this.y + radius/2};
        g.fillPolygon(xPoints1, yPoints1, 3);

    }
}

