package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.experimental.Helper;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Menu extends JLabel {
    @Getter
    private JSlider jSlider1;
    @Getter
    private JSlider jSlider2;
    @Getter
    private JSlider jSlider3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    @Getter
    private JComboBox jComboBox;
    public static final String CIRCLE_JCB = "CIRCLE";
    public static final String HOURS_JCB = "HOURS";
    public static final String SQUARE_JCB = "SQUARE";

    public Menu() {
        setBackground(Color.blue);
        setLayout(new GridLayout(3,3));
        setSize(100, 800);
        setFocusable(false);

        jSlider1 = new JSlider(JSlider.VERTICAL, 20, 200, 50);
        jSlider1.setMinorTickSpacing(10);
        jSlider1.setMajorTickSpacing(10);
        jSlider1.setSnapToTicks(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setPaintLabels(true);

        jSlider2 = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        jSlider2.setMinorTickSpacing(1);
        jSlider2.setMajorTickSpacing(1);
        jSlider2.setSnapToTicks(true);
        jSlider2.setPaintTicks(true);
        jSlider2.setPaintLabels(true);


        jSlider3 = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        jSlider3.setMinorTickSpacing(1);
        jSlider3.setMajorTickSpacing(1);
        jSlider3.setSnapToTicks(true);
        jSlider3.setPaintTicks(true);
        jSlider3.setPaintLabels(true);

        jLabel1 = new JLabel("length");
        jLabel2 = new JLabel("radius");
        jLabel3 = new JLabel("spacing");

        String[] string = {CIRCLE_JCB, HOURS_JCB, SQUARE_JCB};
        jComboBox = new JComboBox(string);
        jComboBox.setSelectedIndex(0);

        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(jSlider1);
        add(jSlider2);
        add(jSlider3);

        add(jComboBox);

        setVisible(true);
    }
}
