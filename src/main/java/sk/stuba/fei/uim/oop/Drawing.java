package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Drawing extends Canvas implements MouseMotionListener {
    private Menu menu;
    private int length;
    private int lastLength;
    private ArrayList<MousePosition> mousePositions;
    public Drawing(Menu menu) {
//        setBackground(Color.yellow);
        this.menu = menu;
        this.length = menu.getJSlider1().getValue();
        lastLength = length;
        System.out.println(length);
        setFocusable(true);
        addMouseMotionListener(this);
        mousePositions = new ArrayList<>();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        lastLength = length;
        length = menu.getJSlider1().getValue();
        if (length != lastLength && length < lastLength) {
            if (lastLength - length > 0) {
                mousePositions.subList(0, lastLength - length).clear();
            }
        }

        if (mousePositions.size() > length) {
            mousePositions.remove(0);
        }
        mousePositions.add(new MousePosition(x, y));


        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (mousePositions.size() < 1) {
            return;
        }
        for (int i=0; i < mousePositions.size()-1; i++) {
            g.drawLine(mousePositions.get(i).getX(), mousePositions.get(i). getY(), mousePositions.get(i+1).getX(), mousePositions.get(i+1). getY());
        }
    }
}
