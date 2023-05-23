package sk.stuba.fei.uim.oop.shape;

import java.awt.*;

public class Circle {
    private final int x;
    private final int y;
    private final int size;
    public Circle(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics g) {
        g.drawOval(x-size/2, y-size/2, size, size);
    }
}
