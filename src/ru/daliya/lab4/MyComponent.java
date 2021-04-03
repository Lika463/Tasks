package ru.daliya.lab4;

import javax.swing.*;
import java.awt.*;

public class MyComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(100, 100, 200, 200 );


    }

    public static void main(String[] args) {
        JFrame frame=new JFrame("JComponent");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        MyComponent comp = new MyComponent();
        frame.getContentPane().add(comp);
    }
}
