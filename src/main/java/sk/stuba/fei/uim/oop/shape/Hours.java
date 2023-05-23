package sk.stuba.fei.uim.oop.shape;

import java.awt.*;

public class Hours {
    private final int x;
    private final int y;
    private final int size;
    public Hours(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics g) {
        int[] xPoints= {x-size/2, x+size/2, x-size/2, x+size/2, x-size/2};
        int[] yPoints = {y-size/2, y+size/2, y+size/2, y-size/2, y-size/2};
        g.drawPolygon(xPoints, yPoints, 5);
    }
}
