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
        setLayout(new BorderLayout());
        setSize(100, 800);
        setFocusable(false);

        initJSliderLength();
        initJSliderRadius();
        initJSliderSpacing();

        JLabel jLabel1 = new JLabel("length");
        jLabel1.setHorizontalAlignment(0);
        JLabel jLabel2 = new JLabel("radius");
        jLabel2.setHorizontalAlignment(0);
        JLabel jLabel3 = new JLabel("spacing");
        jLabel3.setHorizontalAlignment(0);

        String[] string = {CIRCLE_JCB, HOURS_JCB, SQUARE_JCB};
        jComboBox = new JComboBox(string);
        jComboBox.setSelectedIndex(0);

        JPanel jPanelLabelContainer = new JPanel();
        jPanelLabelContainer.setLayout(new GridLayout(1, 3));
        jPanelLabelContainer.add(jLabel1);
        jPanelLabelContainer.add(jLabel2);
        jPanelLabelContainer.add(jLabel3);
        add(jPanelLabelContainer, BorderLayout.PAGE_START);

        JPanel jPanelSliderContainer = new JPanel();
        jPanelSliderContainer.setLayout(new GridLayout(1, 3));
        jPanelSliderContainer.add(jSliderLength);
        jPanelSliderContainer.add(jSliderRadius);
        jPanelSliderContainer.add(jSliderSpacing);
        add(jPanelSliderContainer, BorderLayout.CENTER);

        add(jComboBox, BorderLayout.PAGE_END);

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
