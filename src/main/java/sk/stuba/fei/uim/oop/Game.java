package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Game {
    public Game() {
        JFrame frame = new JFrame("Exam");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setResizable(false);

        Menu menu = new Menu();
        Drawing drawing = new Drawing(menu);
        drawing.setFocusable(true);
        frame.add(drawing, BorderLayout.CENTER);
        frame.add(menu, BorderLayout.EAST);


        frame.setVisible(true);
    }
}
