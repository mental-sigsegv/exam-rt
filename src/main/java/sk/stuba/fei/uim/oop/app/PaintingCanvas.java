package sk.stuba.fei.uim.oop.app;

import sk.stuba.fei.uim.oop.mouse.MousePosition;
import sk.stuba.fei.uim.oop.shape.Circle;
import sk.stuba.fei.uim.oop.shape.Hours;
import sk.stuba.fei.uim.oop.shape.Square;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

import static sk.stuba.fei.uim.oop.app.Menu.*;

public class PaintingCanvas extends Canvas implements MouseMotionListener, ItemListener, ChangeListener {
    private final Menu menu;
    private int length;
    private int lastLength;
    private final ArrayList<MousePosition> mousePositions;
    public PaintingCanvas(Menu menu) {
        this.menu = menu;
        this.length = menu.getJSliderLength().getValue();
        lastLength = length;
        setFocusable(true);
        addMouseMotionListener(this);
        mousePositions = new ArrayList<>();

        initMenuListeners();
    }

    private void initMenuListeners() {
        menu.getJSliderLength().addChangeListener(this);
        menu.getJSliderRadius().addChangeListener(this);
        menu.getJSliderSpacing().addChangeListener(this);
        menu.getJComboBox().addItemListener(this);
    }

    private void storeLines(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        removeExcessLines();
        if (mousePositions.size() > length) {
            mousePositions.remove(0);
        }
        mousePositions.add(new MousePosition(x, y));
        repaint();
    }

    private void removeExcessLines() {
        lastLength = length;
        length = menu.getJSliderLength().getValue();
        if (length != lastLength && length < lastLength) {
            if (lastLength - length > 0) {
                mousePositions.subList(0, lastLength - length).clear();
            }
        }
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
            g.setColor(new Color(255-i*(255/mousePositions.size()), i*(255/mousePositions.size()), 0));
            g.drawLine(mousePositions.get(i).getX(), mousePositions.get(i). getY(), mousePositions.get(i+1).getX(), mousePositions.get(i+1). getY());
            if (counter % menu.getJSliderSpacing().getValue() == 0) {
                drawShape(g, mousePositions.get(i).getX(), mousePositions.get(i). getY());
            }
            counter++;
        }
        if (mousePositions.size() > 1) {
            drawShape(g, mousePositions.get(mousePositions.size()-2).getX(), mousePositions.get(mousePositions.size()-2). getY());
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        removeExcessLines();
        repaint();
    }

    private void drawShape(Graphics g, int x, int y) {
        switch (Objects.requireNonNull(menu.getJComboBox().getSelectedItem()).toString()) {
            case CIRCLE_JCB:
                Circle circle = new Circle(x, y, menu.getJSliderRadius().getValue());
                circle.draw(g);
                break;
            case SQUARE_JCB:
                Square square = new Square(x, y, menu.getJSliderRadius().getValue());
                square.draw(g);
                break;
            case HOURS_JCB:
                Hours hours = new Hours(x, y, menu.getJSliderRadius().getValue());
                hours.draw(g);
        }
    }
}
