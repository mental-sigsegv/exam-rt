package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.shape.Circle;
import sk.stuba.fei.uim.oop.shape.Hours;
import sk.stuba.fei.uim.oop.shape.Square;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Objects;

import static sk.stuba.fei.uim.oop.Menu.*;

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

    private void storeLines(MouseEvent e) {
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
    public void mouseDragged(MouseEvent e) {
        storeLines(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        storeLines(e);
    }

    @Override
    public void paint(Graphics g) {
        if (mousePositions.size() < 1) {
            return;
        }
        int counter = 0;
        for (int i=0; i < mousePositions.size()-1; i++) {
            g.drawLine(mousePositions.get(i).getX(), mousePositions.get(i). getY(), mousePositions.get(i+1).getX(), mousePositions.get(i+1). getY());
            if (counter % menu.getJSlider3().getValue() == 0) {
                drawShape(g, mousePositions.get(i).getX(), mousePositions.get(i). getY());
            }
            counter++;
        }
    }

    private void drawShape(Graphics g, int x, int y) {
        switch (Objects.requireNonNull(menu.getJComboBox().getSelectedItem()).toString()) {
            case CIRCLE_JCB:
                Circle circle = new Circle(x, y, menu.getJSlider2().getValue());
                circle.draw(g);
                break;
            case SQUARE_JCB:
                Square square = new Square(x, y, menu.getJSlider2().getValue());
                square.draw(g);
                break;
            case HOURS_JCB:
                Hours hours = new Hours(x, y, menu.getJSlider2().getValue());
                hours.draw(g);
        }

    }
}
