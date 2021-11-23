package com.white.daily;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author tcs
 * @date Created in 2021-04-29
 */
public class AWTGraphicsDemo extends Frame {

    public AWTGraphicsDemo() {
        super("Circle");
        prepareGUI();
    }

    public static void main(String[] args) {
        AWTGraphicsDemo awtGraphicsDemo = new AWTGraphicsDemo();
        awtGraphicsDemo.setVisible(true);
    }

    private void prepareGUI() {
        setSize(1000, 1000);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        draw(g, 500, 900, 0);
    }

    private void draw(Graphics g, double x, double y, double s) {
        if (s > 3.14 * 2) {
            return;
        }
        point(g, x, y);
        s += 0.314 / 180;
        draw(g, x + Math.cos(s) * 400 * 0.314 / 180, y - Math.sin(s) * 400 * 0.314 / 180, s);
    }

    private void point(Graphics g, double x, double y) {
        g.drawLine((int) x, (int) y, (int) x, (int) y);
    }
}
