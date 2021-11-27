package ch12.gui;
import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class MyDrawPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Color startColor = rndColor();
        Color endColor = rndColor();
        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }

    private int rndInt255() {
        return new Random().nextInt(256);
    }

    private Color rndColor() {
        int r = rndInt255();
        int g = rndInt255();
        int b = rndInt255();
        return new Color(r, g, b);
    }
}