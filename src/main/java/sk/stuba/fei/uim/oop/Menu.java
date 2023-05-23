package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class Menu extends JLabel {
    @Getter
    private JSlider jSliderLength;
    @Getter
    private JSlider jSliderRadius;
    @Getter
    private JSlider jSliderSpacing;
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

        initJSliderLength();
        initJSliderRadius();
        initJSliderSpacing();

        JLabel jLabel1 = new JLabel("length");
        JLabel jLabel2 = new JLabel("radius");
        JLabel jLabel3 = new JLabel("spacing");

        String[] string = {CIRCLE_JCB, HOURS_JCB, SQUARE_JCB};
        jComboBox = new JComboBox(string);
        jComboBox.setSelectedIndex(0);

        add(jLabel1);
        add(jLabel2);
        add(jLabel3);

        add(jSliderLength);
        add(jSliderRadius);
        add(jSliderSpacing);

        add(jComboBox);

        setVisible(true);
    }

    private void initJSliderSpacing() {
        jSliderSpacing = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        jSliderSpacing.setMinorTickSpacing(1);
        jSliderSpacing.setMajorTickSpacing(1);
        jSliderSpacing.setSnapToTicks(true);
        jSliderSpacing.setPaintTicks(true);
        jSliderSpacing.setPaintLabels(true);
    }

    private void initJSliderRadius() {
        jSliderRadius = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        jSliderRadius.setMinorTickSpacing(1);
        jSliderRadius.setMajorTickSpacing(1);
        jSliderRadius.setSnapToTicks(true);
        jSliderRadius.setPaintTicks(true);
        jSliderRadius.setPaintLabels(true);
    }

    private void initJSliderLength() {
        jSliderLength = new JSlider(JSlider.VERTICAL, 20, 200, 50);
        jSliderLength.setMinorTickSpacing(10);
        jSliderLength.setMajorTickSpacing(10);
        jSliderLength.setSnapToTicks(true);
        jSliderLength.setPaintTicks(true);
        jSliderLength.setPaintLabels(true);
    }
}
